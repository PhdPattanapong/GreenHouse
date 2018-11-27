package thailand.thathiew.pattanapong.greenhouse;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.PrivateKey;

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

            } // onDataChange

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }   // Main Method

}   // Main Class
