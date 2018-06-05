package com.tomiyama.noir.sharedtext;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tomiyama.noir.sharedtext.Model.APIResponse;
import com.tomiyama.noir.sharedtext.Model.ApiService;
import com.tomiyama.noir.sharedtext.Model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private Retrofit mRetrofit;
    private ApiService mService;

    // API KEY 各自Consoleから作成
    private final String API_KEY = "dummyAPIKey";

    private final String FIELDS = "items(id,snippet(channelTitle,title,thumbnails),statistics)";
    private final String PART = "snippet,contentDetails,statistics";

    // "livetune feat. 初音ミク 『Tell Your World』Music Video"
    private String testId = "PqJNc9KVIZE";

    ImageView picture;

    TextView title;

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = mRetrofit.create(ApiService.class);

        picture = findViewById(R.id.picture);

        title = findViewById(R.id.title);

        button = findViewById(R.id.button);

        button.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Call<APIResponse> mCall = mService.requestMovie(testId,API_KEY,FIELDS,PART);

            mCall.enqueue(new Callback<APIResponse>() {
                @Override
                public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {

                    // レスポンスからItemを取得
                    List<Item> items = response.body().getItems();

                    for(Item item : items){
                        Log.d("id",item.getId());

                        Uri uri = Uri.parse(item.getSnippet().getThumbnails().getHigh().getUrl());
                        Uri.Builder builder = uri.buildUpon();
                        AsyncTaskHttpRequest task = new AsyncTaskHttpRequest(picture);
                        task.execute(builder);

                        title.setText(item.getSnippet().getTitle());
                    }

                }

                @Override
                public void onFailure(Call<APIResponse> call, Throwable t) {
                    Log.d("failure","failure");

                }
            });

        }
    };

}
