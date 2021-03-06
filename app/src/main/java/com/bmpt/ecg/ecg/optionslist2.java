package com.bmpt.ecg.ecg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raihan on 05-Apr-16.
 */

/**
 * This class is sets the menu for the Options. We added a list view  containing items that performs certain tasks when clicked
 */
public class optionslist2 extends Activity {
    ListView list_view1;//initiating list view
    List<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    private static final int REQUEST_CHOOSER = 1234;


    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionsmenu);
        list_view1 = (ListView) findViewById(R.id.listviewoptions);
        list.add("Generate combined ECG from existing xml file");// adding generate combined ECG from existing xml to the list

        list.add("Edit Organisation Name");// organisation name to the list which when clicked allows the user to change the organisation name
        list.add("Send xml by email");// sending xml file via email, allows the user to send the xml file via email
        list.add("Exit");// exit

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
        list_view1.setAdapter(adapter);// setting the adapter
        list_view1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
                switch (i) {

                    case 0:
                 //code for generating Combined ECG

                        break;
                    case 1:
                        //Code handling for Organisation Name
                        final EditText input = new EditText(optionslist2.this);//edit text for entering organisation name

                        //we define a custom layout, a popup menu that appeares asking for the new organisation name
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,// layout hight
                                LinearLayout.LayoutParams.MATCH_PARENT);// layout width
                        input.setLayoutParams(lp);

                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(optionslist2.this);
                        alertDialog.setTitle("Organisation Name");// title of the popup menu
                        alertDialog.setMessage("Enter Organisation Name");// message that will appear in the popup menu
                        alertDialog.setIcon(R.drawable.org);// setting an icon in the title
                        alertDialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {//button that will update the organisation name
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences preferences=getSharedPreferences("Organisation_Name",Context.MODE_PRIVATE);//setting shared preference
                                SharedPreferences.Editor editor=preferences.edit();// setting editor of the shared preference
                                editor.putString("OrgName",input.getText().toString());// getting the text input from the user and saving it to the shared preference
                                editor.commit();
                                Toast.makeText(getBaseContext(), "Update Successful", Toast.LENGTH_SHORT).show();// success message
                                Intent i = new Intent(optionslist2.this, ECG_MAIN.class);// intent for starting ecg class
                                startActivity(i);// starting ecg main activity, this is done so that the tile refreshes and the new name apprears
                            }
                        });
                        alertDialog.setView(input); // alert dialogue is set as input type
                        alertDialog.show();

                        break;
                    case 2:
                        //Code handling for send xml by email
                      /*  setContentView(R.layout.useridpass);
                        final EditText username=(EditText)findViewById(R.id.user_name_edit_text);
                        final EditText password=(EditText)findViewById(R.id.password_edit_text);
                        final EditText confirm=(EditText)findViewById(R.id.confirm_password_edit_text);
                        final Button update=(Button)findViewById(R.id.updatebutton);

                        final Button cancel=(Button)findViewById(R.id.cancelbutton);
                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                finish();
                            }
                        });

                        update.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String pass= password.getText().toString();
                                String confirmpass= confirm.getText().toString();

                                if (pass.equals(confirmpass)){
                                    SharedPreferences preferences=getSharedPreferences("userdata", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor=preferences.edit();
                                    editor.putString("UserName",username.getText().toString());
                                    editor.putString("Password",confirm.getText().toString());
                                    editor.commit();
                                Toast.makeText(getBaseContext(), "Update Successful", Toast.LENGTH_SHORT).show();
                                 finish();
                            }
                                else {

                                    Toast.makeText(getBaseContext(), "Password Mismatch", Toast.LENGTH_SHORT).show();


                                }

                            }

                        });*/

                       /* final EditText name=new EditText(optionslist2.this);
                        final EditText pass=new EditText(optionslist2.this);
                        final EditText confpass=new EditText(optionslist2.this);
                         name.setHint("Enter User Name");
                        pass.setHint("Enter Password");
                        confpass.setHint("Confirm Password");
                        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.MATCH_PARENT);
                        name.setLayoutParams(lp1);
                        pass.setLayoutParams(lp1);
                        confpass.setLayoutParams(lp1);
                        AlertDialog.Builder alertdialogue1=new AlertDialog.Builder(optionslist2.this);
                        alertdialogue1.setTitle("Enter User Name and Password");
                        alertdialogue1.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String pass1= pass.getText().toString();
                                String confirmpass= confpass.getText().toString();

                                if (pass1.equals(confirmpass)){
                                    SharedPreferences preferences=getSharedPreferences("userdata", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor=preferences.edit();
                                    editor.putString("UserName",name.getText().toString());
                                    editor.putString("Password",confpass.getText().toString());
                                    editor.commit();
                                    Toast.makeText(getBaseContext(), "Update Successful", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                                else {

                                    Toast.makeText(getBaseContext(), "Password Mismatch", Toast.LENGTH_SHORT).show();


                                }

                            }
                        });
                        alertdialogue1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                             finish();
                            }
                        });

                         alertdialogue1.show();*/



                        break;
                    case 3:
                        ///Code handling for add/delete user
                        finish();
                        break;
                    case 4:
                        //Code handling for exit

                        break;
                    case 5:

                        break;


                }
            }
        });


    }




}