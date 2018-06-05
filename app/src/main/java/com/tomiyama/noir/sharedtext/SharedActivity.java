package com.tomiyama.noir.sharedtext;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class SharedActivity extends AppCompatActivity {

    TextView textView;

    ImageView thumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        textView = findViewById(R.id.movieId);
        thumbnail = findViewById(R.id.thumbnail);

        Intent intent = getIntent();

        String id = null;

        if(intent.getType().equals("text/plain")){

            // TODO ListViewにした際に，Youtubeに飛べるように保持
            String text = intent.getStringExtra(Intent.EXTRA_TEXT);
            Log.d("text",text);

            // URLからIDを取得
            id = text.substring(17,text.length());

//            textView.setText(id);
        }

        StringBuilder sb = new StringBuilder();

        // 取得したidでURLを生成する
        if(id != null){
            sb.append("http://img.youtube.com/vi/");
            sb.append(id);
            sb.append("/hqdefault.jpg");
        }

        Uri uri = Uri.parse(String.valueOf(sb));
        Uri.Builder builder = uri.buildUpon();
        AsyncTaskHttpRequest task = new AsyncTaskHttpRequest(thumbnail);
        task.execute(builder);

    }
}
