package com.example.arif.databaseinfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
DatabaseAdapter helper;
    private EditText fName,lName,batch;
    private CustomAdapter adapter;
    private ListView lv;
   List<Data> data=new ArrayList<Data>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new DatabaseAdapter(this);
        fName= (EditText) findViewById(R.id.editText);
        lName= (EditText) findViewById(R.id.editText2);
        batch= (EditText) findViewById(R.id.editText3);

    }
   public void addUser(View view){
       String fname=fName.getText().toString();

       String lname=lName.getText().toString();

       String btch=batch.getText().toString();
       fName.setText("");
       lName.setText("");
       batch.setText("");
       long id=helper.insertData(fname,lname,btch);
       if(id<0)
       {
           Message.message(this,"unsuccessful ");
       }
       else
       {
           Message.message(this,"Successfull");
       }
    }
    public void showAll()
    {
    data= helper.showAllData();
     adapter= new CustomAdapter(this,R.layout.list_view,data);


        lv= (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

    }
}
