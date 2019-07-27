package com.apps.aplikasiresepmasakan.view.SemuaMenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.aplikasiresepmasakan.R;
import com.apps.aplikasiresepmasakan.view.Main2Activity;
import com.apps.aplikasiresepmasakan.view.MakananBerat.MakananBeratFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class IsiSemuaActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_isi_semua);
        //////////////////////////////////////////////////////////////

        ButterKnife.bind(this);

        String gambar = getIntent().getExtras().getString("gambar");
        String nama_masakan = getIntent().getExtras().getString("nama_masakan");
        String resep_masakan = getIntent().getExtras().getString("resep_masakan");
        String cara_masak = getIntent().getExtras().getString("cara_masak");

        ImageView gambarx = (ImageView)findViewById(R.id.img_isi_semua);
        TextView nama_masakanx = (TextView)findViewById(R.id.txtNama_isi_semua);
        TextView resep_masakanx = (TextView)findViewById(R.id.txtBahan_isi_semua);
        TextView cara_masakx = (TextView)findViewById(R.id.txtCaraMasak_isi_semua);

        nama_masakanx.setText(nama_masakan);
        resep_masakanx.setText(resep_masakan);
        cara_masakx.setText(cara_masak);
        Glide.with(this)
                .load("https://kostlab.id/project/eko/xfile/gambar_makanan/"+gambar)
                .apply(new RequestOptions().override(100,100).centerCrop())
                .into(gambarx);
        ////////////////////////////////////////////////////////////////////



    }
//        @OnClick(R.id.img_back_semua)
//        public void back() {
//            Intent in = new Intent(IsiSemuaActivity.this, Main2Activity.class);
//            startActivity(in);
//        }









    @OnClick(R.id.img_back_semua)
    public void back() {
        fragment = new MakananBeratFragment();
        callFragment(fragment);

    }

    private void callFragment(Fragment fragment) {
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
    }




}
