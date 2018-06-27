package com.happycoderz.espa.Activity;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.happycoderz.espa.R;
import com.happycoderz.espa.helper.CacheHelper;
import com.happycoderz.espa.model.EspaResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    CacheHelper cacheHelper;
    EspaResponse espaResponse;

    @BindView(R.id.tv_contact_info)
    TextView contactInfoText;
    @BindView(R.id.tv_address)
    TextView addressText;
    @BindView(R.id.tv_phone)
    TextView phoneText;
    @BindView(R.id.tv_mail)
    TextView emailText;
    @BindView(R.id.contact_us_back_icon)
    ImageView contactUsBackIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);
        cacheHelper = new CacheHelper(this);
        espaResponse = new EspaResponse();
        espaResponse = cacheHelper.getObject("espaInfo",EspaResponse.class);

        setInfoText();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Double espaLatitude = 36.4367151260376;
        Double espaLongtitude = 41.225408647562936;

        LatLng espaInsaat = new LatLng(espaLongtitude,espaLatitude);
        mMap.addMarker(new MarkerOptions().position(espaInsaat).title("Espa İnşaat"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(espaInsaat));
    }

    private void setInfoText(){
        contactInfoText.setText(espaResponse.contact.get(0).getTitle());
        addressText.setText(espaResponse.contact.get(0).getAddress());
        phoneText.setText(espaResponse.contact.get(0).getPhoneNumber());
        emailText.setText(espaResponse.contact.get(0).getEmail());
    }
    @OnClick(R.id.contact_us_back_icon)
    void onContactBackClicked(){
        startActivity(new Intent(ContactActivity.this,MainActivity.class));
        finish();
    }
}
