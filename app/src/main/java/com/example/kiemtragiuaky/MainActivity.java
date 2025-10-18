package com.example.kiemtragiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txtHoTen, txtEmail, txtSdt;
    RadioGroup radioGioiTinh;
    Button btnLuu,btnLamMoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtHoTen=findViewById(R.id.txtHoTen);
        txtEmail=findViewById(R.id.txtEmail);
        txtSdt=findViewById(R.id.txtsdt);
        radioGioiTinh=findViewById(R.id.radioGioiTinh);
        btnLuu=findViewById(R.id.btnLuu);
        btnLamMoi=findViewById(R.id.btnLamMoi);
        btnLamMoi.setOnClickListener(v -> {
            txtHoTen.setText("");
            txtEmail.setText("");
            txtSdt.setText("");
            radioGioiTinh.clearCheck();
        });
        btnLuu.setOnClickListener(v -> {
            String hoTen=txtHoTen.getText().toString().trim();
            String email=txtEmail.getText().toString().trim();
            String sdt=txtSdt.getText().toString().trim();
            if (hoTen.isEmpty())
            {
                Toast.makeText(this,"Vui lòng nhập Họ và tên",Toast.LENGTH_SHORT).show();
                txtHoTen.requestFocus();
                return;
            }
            if (sdt.isEmpty())
            {
                Toast.makeText(this,"Vui lòng nhập Số điện thoa",Toast.LENGTH_SHORT).show();
                txtSdt.requestFocus();
                return;
            }
            String gioiTinh="";
            int chon= radioGioiTinh.getCheckedRadioButtonId();
            if(chon !=-1)
            {
                RadioButton nutChon=findViewById(chon);
                gioiTinh=nutChon.getText().toString();
            }
            else
            {
                Toast.makeText(this,"Vui lòng chọn giới tinnh",Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent=new Intent(MainActivity.this,Profile.class);
            intent.putExtra("hoTen",hoTen);
            intent.putExtra("email",email);
            intent.putExtra("sdt",sdt);
            intent.putExtra("gioiTinh",gioiTinh);
            startActivity(intent);
        });
    }
}