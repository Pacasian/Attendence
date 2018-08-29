package pa.pacasian.sumithkumar.attendenceapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd=new ProgressDialog(this);
        firebaseAuth= FirebaseAuth.getInstance();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Really Exit ??");
        builder.setTitle("Exit");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok",new MyListener());
        builder.setNegativeButton("Cancel",null);
        builder.show();
    }
    public class MyListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }
    }

    public void fn(View view){
        if(view.getId()==R.id.teacherButton){
            // Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            final Dialog login=new Dialog(this);
            login.setContentView(R.layout.activity_teacher_login);
            Button btn_login=login.findViewById(R.id.button3);
            Button btn_Cancel=login.findViewById(R.id.btn_cancel);
            final EditText ed_login=login.findViewById(R.id.editText);
            final EditText ed_password=login.findViewById(R.id.editText2);
            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String user=ed_login.getText().toString().trim();
                    String pass=ed_password.getText().toString().trim();
                    if(user.equals("abc")&&pass.equals("abc")){
                        Intent intent=new Intent(MainActivity.this,TeacherActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            btn_Cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login.dismiss();
                }
            });
            login.show();
        }
        else{
            final Dialog login1=new Dialog(this);
            login1.setContentView(R.layout.activity_student_login);
            Button btn_login=login1.findViewById(R.id.signinButton);
            Button btn_Cancel1=login1.findViewById(R.id.btn_cancel1);
            final EditText ed_login1=login1.findViewById(R.id.editText3);
            final EditText ed_pass1=login1.findViewById(R.id.editText4);
            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String email=ed_login1.getText().toString().trim();
                    String password=ed_pass1.getText().toString().trim();
                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(MainActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                        return ;
                    }
                    if (TextUtils.isEmpty(password)) {
                        Toast.makeText(MainActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                        return ;
                    }
                    pd.setMessage("Signing In");
                    pd.setCancelable(false);
                    pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    pd.show();
                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "SignIn Successful", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(MainActivity.this,StudentInformationActivity.class);
                                intent.putExtra("Name","Email");
                                intent.putExtra("Email",email);
                                firebaseAuth.signOut();
                                startActivity(intent);
                                pd.dismiss();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Oops!! Wrong credentials", Toast.LENGTH_SHORT).show();
                                pd.dismiss();
                            }
                        }
                    });

                }
            });
            btn_Cancel1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login1.dismiss();
                }
            });
            login1.show();
        }
        }
    }


