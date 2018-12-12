package com.example.namu.galleryver01;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Debug;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.mbms.FileInfo;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    final int REQUEST_ID_READ_WRITE_PERMISSION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askPermissonForAccessFile();

        //String url = "https://i.pinimg.com/originals/f5/05/ec/f505ec4a493959f044923174e92d7b79.jpg";
/*
        Glide.with(this)
                .load("http://via.placeholder.com/300.png")
                .placeholder(R.drawable.image_loading)
                .error(R.drawable.image_break)
                .into(imageView);

        Glide.with(this)
                .load("https://i.pinimg.com/originals/f5/05/ec/f505ec4a493959f044923174e92d7b79.jpg")
                .into(imageView);

        Glide.with(this)
                .load("http://via.placeholder.com/300.png")
                .placeholder(R.drawable.image_loading)
                .error(R.drawable.image_break)
                .into(imageView02);

        Glide.with(this)
                .load("https://kenh14cdn.com/2018/3/25/c820e2ce8b0935c083357d958d6b0579-1521987239451345799146.jpg")
                .into(imageView02);

        Glide.with(this)
                .load("http://via.placeholder.com/300.png")
                .placeholder(R.drawable.image_loading)
                .error(R.drawable.image_break)
                .into(imageView03);

        Glide.with(this)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSclE520de3-E4CV98ExkCKDhPLK5zkmV4CRb2GXzXSe-7URPHO")
                .into(imageView03);
*/
        File dir = Environment.getExternalStorageDirectory();
        String res = Environment.getExternalStorageState();
        Context context = getApplicationContext();
        CharSequence text = res;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File videosFolder = new File(Environment.getExternalStorageDirectory(), "GOGOvideos"); // tao thu muc ten GOGOvideos
        videosFolder.mkdirs(); // tao ra 1 folder de chua anh

        // duong dan toi thu muc chua video voi hinh anh cua ung dung
        String path = dir.getAbsolutePath()+"/GOGOvideos";

        // hien tai dir dang giu duong dan toi thu muc
        Toast toast1 = Toast.makeText(context, path, Toast.LENGTH_SHORT);
        toast1.show();

        String path02 = Environment.getExternalStorageDirectory().toString()+"/GOGOvideos";

        File f = new File(path02);
        File file[] = f.listFiles();

        for(int i=0;i<file.length;++i)
        {
            String tempPath =file[i].getAbsolutePath().toString();
            Log.d("filename",tempPath);

        }

    }


    private void askPermissonForAccessFile() {
        // Với Android Level >= 23 bạn phải hỏi người dùng cho phép đọc/ghi dữ liệu vào thiết bị.
        if (android.os.Build.VERSION.SDK_INT >= 23) {

            // Kiểm tra quyền đọc/ghi dữ liệu vào thiết bị lưu trữ ngoài.
            int readPermission = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE);
            int writePermission = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (writePermission != PackageManager.PERMISSION_GRANTED ||
                    readPermission != PackageManager.PERMISSION_GRANTED) {

                // Nếu không có quyền, cần nhắc người dùng cho phép.
                this.requestPermissions(
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_ID_READ_WRITE_PERMISSION
                );
                return;
            }
        }
    }

}
