package thailand.thathiew.pattanapong.greenhouse;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Setup Color
        TextView textView = findViewById(R.id.txtNumber);
        textView.setTextColor(Color.BLUE);

    }   // Main Method

}   // Main Class
