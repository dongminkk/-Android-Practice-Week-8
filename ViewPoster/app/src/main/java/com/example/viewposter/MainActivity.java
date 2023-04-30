package com.example.viewposter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//레이아웃 지정
        //액션바
        getSupportActionBar().setDisplayShowHomeEnabled(true);//홈버튼 표시
        getSupportActionBar().setIcon(R.drawable.ic);//액션바 아이콘 지정
        setTitle("갤러리 영화 포스터");//액션바 제목

        //갤러리뷰 초기화
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        //어댑터 설정
        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }

    public class MyGalleryAdapter extends BaseAdapter {

        Context context;
        //포스터 이미지 ID 배열
        Integer[] posterID = { R.drawable.po0, R.drawable.po1,
                R.drawable.po2, R.drawable.po3, R.drawable.po4,
                R.drawable.po5, R.drawable.po6, R.drawable.po7,
                R.drawable.po8, R.drawable.po9 };

        //자동완성 추상 메소드 4개

        //어댑터 생성자
        public MyGalleryAdapter(Context c) {context = c;}

        //어댑터가 관리하는 아이탬 개수 반환
        public int getCount() {return posterID.length;}

        //아이탬 반환
        public Object getItem(int arg0) {return null;}

        //아이탬 ID 반환
        public long getItemId(int position) {return 0;}

        //position 위치의 포스터 이미지를 보여주는 뷰 반환
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);
            imageview.setImageResource(posterID[position]);

            final int pos = position;
            //포스터 이미지를 선택시 매인 이미지뷰에 해당 포스터 출력
            imageview.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);
                    return false;
                }
            });

            return imageview;
        }
    }
}
