package edu.rosehulman.rodrigr1.comicviewer;

import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

/**
 * Created by rodrigr1 on 1/13/2016.
 */
public class GetComicTask extends AsyncTask<String, Void, Comic> {

    private static final String EXCEPTION_TAG = "wut";
    private ComicConsumer mComicConsumer;

    public GetComicTask(ComicConsumer activity) { mComicConsumer = activity; }

    @Override
    protected Comic doInBackground(String... urlStrings) {
        String urlString = urlStrings[0];
        Comic comic = null;
        try {
            comic = new ObjectMapper().readValue(new URL(urlString), Comic.class);
        } catch (IOException e) {
            Log.d(EXCEPTION_TAG, "ERROR: " + e.toString());
        }
        return comic;
    }

    @Override
    protected void onPostExecute(Comic comic){
        super.onPostExecute(comic);
        mComicConsumer.useComic(comic);
    }

    public interface ComicConsumer {
        void useComic(Comic comic);
    }
}
