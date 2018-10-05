package com.example.masho.bloodbankapplication;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Post extends AppCompatActivity {

   private EditText name,phone,address,dob,disease;
   private RadioGroup gender;
   private CheckBox donate,need;
   private Button Submit,Cancel;
   private FirebaseDatabase database;
   private DatabaseReference databaseReference;
   private  RadioButton female,male;
   private FirebaseUser user;
   private Spinner BloodGroup;

   private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__post);

        //finding id's.
        name = findViewById(R.id.NameEditText);
        phone = findViewById(R.id.PhoneTextView);
        address = findViewById(R.id.Address);
        dob = findViewById(R.id.DOB);
        disease = findViewById(R.id.Disease);
        gender = findViewById(R.id.Gender);
        donate = findViewById(R.id.DonateBloodCBox);
        need = findViewById(R.id.NeedBloodCBox);
        Submit = findViewById(R.id.SubmitBtn);
        Cancel = findViewById(R.id.CancelBtn);
        BloodGroup = findViewById(R.id.BloodGroup);
        database = FirebaseDatabase.getInstance();
        id = gender.getCheckedRadioButtonId();
        male = findViewById(R.id.Male);
        female= findViewById(R.id.Female);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddDataToDatabase();
            }
        });
    }

    private void AddDataToDatabase() {
        String mName = name.getText().toString();
        String mPhone = phone.getText().toString();
        String mAddress = address.getText().toString();
        String mDob = dob.getText().toString();
        String mDisease = disease.getText().toString();
        user = FirebaseAuth.getInstance().getCurrentUser();
        String Uid = user.getUid();
        databaseReference = database.getReference("AddPost").child(mName);
        databaseReference.child("UserName").setValue(mName);
        databaseReference.child("UserId").setValue(Uid);
        databaseReference.child("PhoneNumber").setValue(mPhone);
        databaseReference.child("Address").setValue(mAddress);
        databaseReference.child("Date_Of_Birth").setValue(mDob);
        databaseReference.child("Disease").setValue(mDisease);
        if(male.isChecked()) {
        databaseReference.child("Gender").setValue("Male");
        }
     else    if(female.isChecked())
        {
            databaseReference.child("Gender").setValue("Female");
        }
        if(donate.isChecked()) {
            databaseReference.child("BloodType").setValue("Donate");
        }
        else  if(need.isChecked()) {
            databaseReference.child("BloodType").setValue("Need");
        }
        else
        {
            databaseReference.child("BloodType").setValue("Donate" + "Need");
        }
        databaseReference.child("BloodGroup").setValue(BloodGroup.getSelectedItem().toString());
        Toast.makeText(getApplicationContext(),"Data saved",Toast.LENGTH_LONG).show();
    }
}
