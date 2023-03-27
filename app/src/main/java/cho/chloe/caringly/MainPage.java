package cho.chloe.caringly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maingpage);
        Button assistant = findViewById(R.id.assistant);
        assistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainPage.this, Assistant.class);
                startActivity(it);
            }
        });
        Button list = findViewById(R.id.support);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainPage.this, List.class);
                startActivity(it);
            }
        });
        Button match = findViewById(R.id.match);
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainPage.this, Match.class);
                startActivity(it);
            }
        });
        Button aboutus = findViewById(R.id.aboutus);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainPage.this, AboutUs.class);
                startActivity(it);
            }
        });
        Button mypage = findViewById(R.id.mypage);
        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainPage.this, MyPage.class);
                startActivity(it);
            }
        });
    }
}
