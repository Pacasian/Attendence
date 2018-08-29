package pa.pacasian.sumithkumar.attendenceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SplashActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=findViewById(R.id.imv);
        textView =findViewById(R.id.txtvi);
        Animation animation1=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.once_blink);
        textView.startAnimation(animation1);
        Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
        imageView.startAnimation(animation);
        new MyThread().start();
    }
    public class MyThread extends Thread{
        public void run(){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Toast.makeText(SplashActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
            finally {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}

/*   Drawable drawable = imageView.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }*/

