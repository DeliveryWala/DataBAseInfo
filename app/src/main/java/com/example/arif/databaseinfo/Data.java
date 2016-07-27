package com.example.arif.databaseinfo;

/**
 * Created by Arif on 27/07/16.
 */
public class Data
{
    private String fName;
    private String lName;
    private String batch;
    public Data(){}

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Data(String f, String l, String b)
    {
        this.fName=f;
        this.lName=l;
        this.batch=b;

    }
}
