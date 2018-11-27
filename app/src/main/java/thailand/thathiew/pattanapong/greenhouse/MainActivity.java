package thailand.thathiew.pattanapong.greenhouse;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.PrivateKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

public class MainActivity extends AppCompatActivity {

    // Explicit
    private String numberString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Setup Color
        final TextView textView = findViewById(R.id.txtNumber);
        textView.setTextColor(Color.BLUE);

        //Connected data base Firebase

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("FromNode");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                NumberModel numberModel = dataSnapshot.getValue(NumberModel.class);
                int numberInt = numberModel.getNumberAnInt();
                Log.d("27NovV1","numberInt ==> "+numberInt);
                textView.setText(Integer.toString(numberInt));

               // Config Color
                if (numberInt>=50) {
                    textView.setTextColor(Color.RED);


                    Calendar calendar = Calendar.getInstance();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String dateString = dateFormat.format(calendar.getTime());
                    Log.d("27NovV1", "dateString ==> "+dateString);


                    DateTimeModel dateTimeModel = new DateTimeModel(dateString, numberInt);
                    FirebaseDatabase firebaseDatabase1 = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference1 = firebaseDatabase1.getReference()
                            .child("RedData");
                    databaseReference1.child(dateString).setValue(dateTimeModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

                        }
                    });


                } // if

            } // onDataChange

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        // Control Switch

        Button switchButton =findViewById(R.id.btnSwitchOn);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateFirebase(1);
            }
        });

        Button switchOffButton = findViewById(R.id.btnSwitchOFF);
       switchOffButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               updateFirebase(0);
           }
       });

    }   // Main Method

    private void updateFirebase(int i) {

    }

}   // Main Class
