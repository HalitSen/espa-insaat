package com.happycoderz.espa.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.happycoderz.espa.R;
import com.happycoderz.espa.helper.CacheHelper;
import com.happycoderz.espa.model.EspaResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutUsActivity extends AppCompatActivity {

    @BindView(R.id.about_us_back_icon)
    ImageView backIcon;
    @BindView(R.id.about_us_toolbar)
    android.support.v7.widget.Toolbar aboutUsToolbar;
    @BindView(R.id.about_us_title)
    TextView aboutUsTitleText;
    @BindView(R.id.about_us_content_tv)
    TextView aboutUsContentText;
    @BindView(R.id.mision_vision_title)
    TextView missionVisionTitle;
    @BindView(R.id.mision_vision_content_tv)
    TextView missionVisionContentText;
    @BindView(R.id.quality_title_tv)
    TextView qualityPolicyTitle;
    @BindView(R.id.quality_policy_content_tv)
    TextView qualityPlicyContentText;

    CacheHelper cacheHelper;
    EspaResponse espaResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ButterKnife.bind(this);

        setSupportActionBar(aboutUsToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getEspaResponse();
        setTextsByResponse();
    }

    private void getEspaResponse(){
        cacheHelper = new CacheHelper(this);
        espaResponse = new EspaResponse();
        espaResponse = cacheHelper.getObject("espaInfo", EspaResponse.class);
    }
    private void setTextsByResponse(){

        aboutUsTitleText.setText(espaResponse.corporate.get(0).getTitle());
        aboutUsContentText.setText(espaResponse.corporate.get(0).content.getTr());
        missionVisionTitle.setText(espaResponse.corporate.get(1).getTitle());
        missionVisionContentText.setText(espaResponse.corporate.get(1).content.getTr());
        qualityPolicyTitle.setText(espaResponse.corporate.get(2).getTitle());
        qualityPlicyContentText.setText(espaResponse.corporate.get(2).content.getTr());
    }
    @OnClick(R.id.about_us_back_icon)
    void onBackIconClicked() {
        startActivity(new Intent(AboutUsActivity.this, MainActivity.class));
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about_us:
                break;
            case R.id.galery:
                Toast.makeText(this, "galery clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact:
                Toast.makeText(this, "contac clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
