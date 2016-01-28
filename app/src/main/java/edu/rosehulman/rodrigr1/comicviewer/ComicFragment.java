package edu.rosehulman.rodrigr1.comicviewer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by rodrigr1 on 1/13/2016.
 */
public class ComicFragment extends Fragment implements GetComicTask.ComicConsumer, GetImageTask.ImageConsumer{
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG = "ComicWrapper";
    protected static final String TAG_DIALOG_TITLE = "Title";
    protected static final String TAG_DIALOG_MESSAGE = "Message";
    private ComicWrapper mComicWrapper;
    private TextView mTitleTextView;
    private ImageView mImageView;
    private PhotoViewAttacher mAttacher;

    public ComicFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ComicFragment newInstance(ComicWrapper cw) {
        ComicFragment fragment = new ComicFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG, cw);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);

        mComicWrapper = getArguments().getParcelable(ARG);
        mTitleTextView = (TextView) rootView.findViewById(R.id.section_label);
        mImageView = (ImageView) rootView.findViewById(R.id.imageView);

        String urlString = String.format("http://xkcd.com/%d/info.0.json", mComicWrapper.getXkcdIssue());

        rootView.setBackgroundColor(ContextCompat.getColor(getContext(), mComicWrapper.getColor()));
        textView.setText(getString(R.string.section_format, mComicWrapper.getXkcdIssue()));

        new GetComicTask(this).execute(urlString);
        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_info) {

            InfoDialog dialog = new InfoDialog();
            Bundle bundle = new Bundle();
            bundle.putString(TAG_DIALOG_TITLE, getString(R.string.dialog_title) + mComicWrapper.getXkcdIssue());
            bundle.putString(TAG_DIALOG_MESSAGE, mComicWrapper.getComic().getAlt());
            dialog.setArguments(bundle);
            dialog.show(getFragmentManager(), "Info Dialog");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void useComic(Comic comic) {
        Log.d("COMIC", "Comic Object\n" + comic);
        mComicWrapper.setComic(comic);
        mTitleTextView.setText(comic.getSafe_title());
        new GetImageTask(this).execute(comic.getImg());
    }

    @Override
    public void useImage(Bitmap bitmap) {
        mImageView.setImageBitmap(bitmap);
        mAttacher = new PhotoViewAttacher(mImageView);
    }
}
