package com.example.bublly.bemedisure;

/**
 * Created by BUBLLY on 20-11-2016.
 */
public class DataProvider
{
    private String email;
    private String password;

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DataProvider(String email,String password)
    {
        this.email = email;
        this.password = password;
    }
}
