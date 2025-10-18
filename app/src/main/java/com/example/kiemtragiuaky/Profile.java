package com.example.kiemtragiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profile extends AppCompatActivity {
    TextView txtHoTen,txtEmail,txtSDT,txtGioiTinh;
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtHoTen=findViewById(R.id.txtHoTen);
        txtEmail=findViewById(R.id.txtEmail);
        txtSDT=findViewById(R.id.txtsdt);
        txtGioiTinh=findViewById(R.id.txtGioiTinh);
        Intent intent=getIntent();
        String hoTen=intent.getStringExtra("hoTen");
        String email=intent.getStringExtra("email");
        String sdt=intent.getStringExtra("sdt");
        String gioiTinh=intent.getStringExtra(("gioiTinh"));
        txtHoTen.setText("Họ và tên: "+hoTen);
        txtEmail.setText("Email: "+email);
        txtSDT.setText("sdt"+sdt);
        txtGioiTinh.setText("gioiTinh"+gioiTinh);
        btnBack.setOnClickListener(v -> {
            finish();
        });
    }
}