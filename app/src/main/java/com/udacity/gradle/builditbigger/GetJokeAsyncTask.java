package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.sohail.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by SOHAIL on 22/09/16.
 */
public class GetJokeAsyncTask extends AsyncTask<Void, Void, String> {

    private static final String LOG_TAG = GetJokeAsyncTask.class.getSimpleName();

    @Override
    protected String doInBackground(Void... voids) {
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setApplicationName("backend")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });

        MyApi myApiService = builder.build();

        String joke = null;

        try {
            joke = myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return joke;
    }

}
