package com.nexis.deneme;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class KanalHarfSabitli4 extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kanal_harf_sabitli4);

        mAuth = FirebaseAuth.getInstance();

        listView = findViewById(R.id.listView);

        // Firebase Realtime Database referansını alın
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("users");

        // ValueEventListener oluşturun
        ValueEventListener usersListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> userEmails = new ArrayList<>();

                // Tüm kullanıcıların e-posta adreslerini alın
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    String userEmail = userSnapshot.getValue(String.class);
                    userEmails.add(userEmail);
                }

                // userEmails listesini bir ListView veya RecyclerView gibi bir arayüzde gösterin
                ArrayAdapter<String> adapter = new ArrayAdapter<>(KanalHarfSabitli4.this, android.R.layout.simple_list_item_1, userEmails);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Hata durumunda işlemler
            }
        };

        // ValueEventListener'ı kullanıcılar referansına ekleyin
        usersRef.addListenerForSingleValueEvent(usersListener);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
