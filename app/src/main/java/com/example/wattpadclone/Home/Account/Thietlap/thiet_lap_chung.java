package com.example.wattpadclone.Home.Account.Thietlap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wattpadclone.Home.Account.AccountActivity;
import com.example.wattpadclone.R;

public class thiet_lap_chung extends AppCompatActivity {
    TextView txtThietLapTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thiet_lap_chung);

        Toolbar toolbar = findViewById(R.id.toolbar_thiet_lap_chung);
        toolbar.setLogo(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txtThietLapTK = findViewById(R.id.txtThietLapTK);
        txtThietLapTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thiet_lap_chung.this, ThietLapTaiKhoan.class);
                startActivity(intent);
            }
        });
    }
}