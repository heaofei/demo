package com.xysh.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

public class MainActivity extends AppCompatActivity {
    private GridViewWithHeaderAndFooter gridView;
    private View head;
    private SliderLayout mSlider;
    private SliderLayout mSliders;

    private GameAdapter gameAdapter;
    List<gamebean> gameBeans = new ArrayList<gamebean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        init();
    }

    private void init() {
        gridView = (GridViewWithHeaderAndFooter)findViewById(R.id.grid);
        initslide();
        initslides();
        addhead();
    }

    private void initslides() {
        mSliders =(SliderLayout) findViewById(R.id.sliders);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://img2.imgtn.bdimg.com/it/u=3084673010,2120270188&fm=21&gp=0.jpg");
        url_maps.put("Big Bang Theory", "http://img5.imgtn.bdimg.com/it/u=1227507720,156751445&fm=21&gp=0.jpg");
        url_maps.put("House of Cards", "http://img1.imgtn.bdimg.com/it/u=2785029742,1781529463&fm=21&gp=0.jpg");
        url_maps.put("Game of Thrones", "http://img1.imgtn.bdimg.com/it/u=2785029742,1781529463&fm=21&gp=0.jpg");


        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
//                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            TextView view =(TextView) textSliderView.getView().findViewById(com.daimajia.slider.library.R.id.description);
            view.setText("dfads");
            mSliders.addSlider(textSliderView);

        }
        mSliders.setPresetTransformer(SliderLayout.Transformer.Default);
        mSliders.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSliders.setDuration(4000);
//        mSlider.addOnPageChangeListener(this);
    }

    private void addhead() {
        gameAdapter = new GameAdapter(this,R.layout.game_item);
        for (int i=0;i<10;i++) {
            gamebean bean = new gamebean();
            gameBeans.add(bean);
        }
        gridView.addHeaderView(head);
        gridView.setAdapter(gameAdapter);
        gridView.setNumColumns(2);

        gameAdapter.addAll(gameBeans);
    }

    private void initslide() {
        LayoutInflater LayoutInflater = (LayoutInflater) getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        head = LayoutInflater.inflate(R.layout.head_view, null);

        mSlider =(SliderLayout) head.findViewById(R.id.slider);


        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://img2.imgtn.bdimg.com/it/u=3084673010,2120270188&fm=21&gp=0.jpg");
        url_maps.put("Big Bang Theory", "http://img5.imgtn.bdimg.com/it/u=1227507720,156751445&fm=21&gp=0.jpg");
        url_maps.put("House of Cards", "http://img1.imgtn.bdimg.com/it/u=2785029742,1781529463&fm=21&gp=0.jpg");
        url_maps.put("Game of Thrones", "http://img1.imgtn.bdimg.com/it/u=2785029742,1781529463&fm=21&gp=0.jpg");


        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
//                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            TextView view =(TextView) textSliderView.getView().findViewById(com.daimajia.slider.library.R.id.description);
            view.setText("dfads");
            mSlider.addSlider(textSliderView);

        }
        mSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setDuration(4000);
//        mSlider.addOnPageChangeListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
