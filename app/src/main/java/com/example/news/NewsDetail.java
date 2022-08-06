package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetail extends AppCompatActivity {

    String author, title, description, url, urlToImage, time, content;
    TextView titleTv, descTv, contentTv;
    ImageView imgTv;
    Button readMore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        author = getIntent().getStringExtra("author");
        title = getIntent().getStringExtra("title");
        description = getIntent().getStringExtra("description");
        url = getIntent().getStringExtra("url");
        urlToImage = getIntent().getStringExtra("urlToImage");
        time = getIntent().getStringExtra("time");
        content = getIntent().getStringExtra("content");

        titleTv = findViewById(R.id.title);
        descTv = findViewById(R.id.desc);
        contentTv = findViewById(R.id.content);
        imgTv = findViewById(R.id.image);
        readMore = findViewById(R.id.readMore);

        titleTv.setText(title);
        descTv.setText(description);
        contentTv.setText(content);
        Picasso.get().load(urlToImage).into(imgTv);

        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}