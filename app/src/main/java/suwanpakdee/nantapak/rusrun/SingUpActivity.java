package suwanpakdee.nantapak.rusrun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SingUpActivity extends AppCompatActivity {

    // Explicit
    private EditText nameEditText, userEditText, passwordEditText;
    private RadioGroup radioGroup;
    private RadioButton avatar0RadioButton, avatar1RadioButton,
            avatar2RadioButton, avatar3RadioButton, avatar4RadioButton;
    private String nameString, userString, passwordString, avatarString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        //Bind Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        userEditText = (EditText) findViewById(R.id.editText2);
        passwordEditText = (EditText) findViewById(R.id.editText3);
        radioGroup = (RadioGroup) findViewById(R.id.radAvatar);
        avatar0RadioButton = (RadioButton) findViewById(R.id.radioButton);
        avatar1RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        avatar2RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        avatar3RadioButton = (RadioButton) findViewById(R.id.radioButton4);
        avatar4RadioButton = (RadioButton) findViewById(R.id.radioButton5);

        //Radio Controller
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {

                    case R.id.radioButton:
                        avatarString = "0";
                        break;
                    case R.id.radioButton2:
                        avatarString = "1";
                        break;
                    case R.id.radioButton3:
                        avatarString = "2";
                        break;
                    case R.id.radioButton4:
                        avatarString = "3";
                        break;
                    case R.id.radioButton5:
                        avatarString = "4";
                        break;
                    
                }   // Switch
            }
        });

    }   // Main Method

    public void clickSignUpSign(View view) {

        //Get Value from Edit Text
        nameString = nameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณาเติมเต็มช่องที่ว่างเปล่าไม่มีอะไรเลยเติมให้มันเต็มเข้าใจไหม");
        } else if (checkchoose()) {
            //Checked
        } else {
            //Un Check
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "ยังไม่เลือก Avatar",
                    "กรุณาเลือก Avatar ด้วยครับ");
            
        }



    } // clickSignUp

    private boolean checkchoose() {

        boolean status = true;

        status = avatar0RadioButton.isChecked() ||
                avatar1RadioButton.isChecked() ||
                avatar2RadioButton.isChecked() ||
                avatar3RadioButton.isChecked() ||
                avatar4RadioButton.isChecked();

        return status;
    }

}   // Main Class
