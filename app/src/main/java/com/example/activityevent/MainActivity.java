package com.example.activityevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi bariabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail,edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada layout
        btnLogin =findViewById(R.id.btSignIn);

        //Menghubungkan variabel edemail dengan componen button pada layout
        edemail =findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada layout
        edpassword =findViewById(R.id.edPassword);

        //membuat fungsi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //mengeset email yang benar
                String email = "admin@mail.com";

                //mengeset password yang benar
                String pass = "123";

                //mengecek apakah edittext email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()) {
                    //membuat variabel toast dan menampilkan pesan "edittext tidak boleh kosong
                    Toast t = Toast.makeText(getApplicationContext(), "Email dan password wajib diisi!!!", Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();
                }else {
                    //membuat variabel toast dan membuat toast dengan menambahkan variabel nam dan password
                    //Tampilan jika email dan password benar
                    if (nama.equals("admin@mail.com")&&password.equals("123")){
                        Toast.makeText(getApplicationContext(),"Login Sukses",Toast.LENGTH_SHORT).show();

                        //Membuat objek bundle
                        Bundle b = new Bundle();

                        //memasukkan value dari variabel nama dengan kunci "a"
                        // dan dimasukkan kedalam bundle
                        b.putString("a", nama.trim());

                        //memasukkan value dari variabel password dengan kunci "b"
                        // dan dimasukkan kedalam bundle
                        b.putString("b", password.trim());

                        //membat objek intent berpindah activity dari mainactivity ke ActivityHasil
                        Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                        //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);

                        //berpindah ke ActivityHasil
                        startActivity(i);
                    }
                    //Tampilan jika password salah
                    else if (nama.equals("admin@mail.com")){
                        Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT).show();
                    }
                    //Tampilan jika email salah
                    else if (password.equals("123")){
                        Toast.makeText(getApplicationContext(), "Email Salah", Toast.LENGTH_SHORT).show();
                    }
                    //Tampilan jika email dan password salah
                    else {
                        Toast.makeText(getApplicationContext(),"Email dan Password Salah",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}