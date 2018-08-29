package pa.pacasian.sumithkumar.attendenceapp;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.GridView;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.Timer;
import java.util.TimerTask;

public class TeacherActivity extends AppCompatActivity {
    GridView gv;
    GridAdapter ga;
    String[] name = {"Take Attendance", "Add new student", "Student Details", "Push Task", "Import Materials", "Contact class Rep."};
    int[] img = {R.drawable.edit, R.drawable.resume, R.drawable.curriculumw, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground};


    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        gv =findViewById(R.id.gride);
        ga = new GridAdapter(getApplicationContext(), name, img);
        gv.setAdapter(ga);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (name[position] == "Take Attendance") {
                    Intent intent1 = new Intent(TeacherActivity.this, SubjectList.class);
                    startActivity(intent1);
                }
                if (name[position] == "Add new student") {
                    Intent intent3 = new Intent(TeacherActivity.this, AddStudentActivity.class);
                    startActivity(intent3);
                }
                if (name[position] == "View Student Details") {
                    Intent intent4 = new Intent(TeacherActivity.this, SelectRollNo.class);
                    startActivity(intent4);
                }
                if (name[position] == "Push Task") {
                    AlertDialog.Builder dlg=new AlertDialog.Builder(TeacherActivity.this);
                    dlg.setMessage("You can shape your idea into a fully fledged product through our most experienced developers in the field of Android Development and IOT, we build your project at most precise manner as you mentioned in a expeditious time.Please note that at present our services are limit to Chennai only..");
                    dlg.setTitle("Transform an idea to a Vibrant Product");
                    dlg.setCancelable(true);
                    dlg.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });dlg.create().show();
                }
                if (name[position] == "Import Materials") {
                    Intent intent5 = new Intent(TeacherActivity.this, AddStudentActivity.class);
                    startActivity(intent5);
                }
                if (name[position] == "Contact class Rep.") {
                    Intent intent6 = new Intent(TeacherActivity.this, MainActivity.class);
                    startActivity(intent6);
                }

            }
        });

    }

}
