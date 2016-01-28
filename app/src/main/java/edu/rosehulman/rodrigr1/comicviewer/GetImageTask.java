package edu.rosehulman.rodrigr1.comicviewer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by rodrigr1 on 1/13/2016.
 */
public class GetImageTask extends AsyncTask<String, Void, Bitmap> {

    private ImageConsumer mImageConsumer;

    public GetImageTask(ImageConsumer activity) { mImageConsumer = activity; }

    @Override
    protected Bitmap doInBackground(String... urlStrings) {

        String urlString = urlStrings[0];
        Bitmap bitmap = null;
        try {
            InputStream in = new java.net.URL(urlString).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (IOException e){

        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap){
        super.onPostExecute(bitmap);
        mImageConsumer.useImage(bitmap);
    }

    public interface ImageConsumer {
        void useImage(Bitmap bitmap);
    }

}
