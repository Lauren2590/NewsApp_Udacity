package com.example.android.newsapp_udacity;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.android.newsapp_udacity.News;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {
    private String mUrl;
    private static final String LOG_TAG = NewsLoader.class.getName();

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<News> news = com.example.android.newsapp_udacity.Utils.fetchNewsData(mUrl);
        Log.e(LOG_TAG, "TEST:loadInBackground");
        return news;
    }
}
