package com.example.masho.bloodbankapplication;

/**
 * Created by Masho on 10/5/2018.
 */

public class ModelShow {

    private String UserName;
    private String Address;
    private String Gender;
    private String PhoneNumber;
    private String BloodGroup;
    private String BloodType;
    private String Disease;

    public ModelShow(String userName, String address, String gender, String phoneNumber, String bloodGroup, String bloodType, String disease) {
        UserName = userName;
        Address = address;
        Gender = gender;
        PhoneNumber = phoneNumber;
        BloodGroup = bloodGroup;
        BloodType = bloodType;
        Disease = disease;
    }

    public ModelShow(){}

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setBloodType(String bloodType) {
        BloodType = bloodType;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }
}
