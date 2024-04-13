package com.nexis.deneme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OyunSecimi extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_oyun_secimi);

        // Firebase Authentication nesnesini başlatın
        mAuth = FirebaseAuth.getInstance();

        // Eğer bir e-posta adresi varsa göster
        userEmail = getIntent().getStringExtra("EMAIL_EXTRA");
        if (userEmail != null) {
            // Hoş geldiniz mesajını oluşturun
            String welcomeMessage = "Hoş geldiniz " + userEmail;

            // Hoş geldiniz mesajını göstermek için bir TextView'ı bulun
            TextView welcomeTextView1 = findViewById(R.id.welcome_text_view_1);
            welcomeTextView1.setText(welcomeMessage);

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Firebase Authentication ile oturum açan kullanıcının bilgilerini alın
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // Kullanıcı oturum açmışsa e-posta adresini alın
            userEmail = currentUser.getEmail();

            // Hoş geldiniz mesajını oluşturun
            String welcomeMessage = "Hoş geldiniz " + userEmail;

            // Hoş geldiniz mesajını göstermek için bir TextView'ı bulun
            TextView welcomeTextView1 = findViewById(R.id.welcome_text_view_1);
            welcomeTextView1.setText(welcomeMessage);

        }
    }

    public void harfSecimi(View view) {
        Intent intent = new Intent(this, HarfSecimi.class);
        startActivity(intent);
    }

    public void harfSecimi2(View view) {
        Intent intent = new Intent(this, HarfSecimi2.class);
        startActivity(intent);
    }
}
