package edu.rosehulman.rodrigr1.comicviewer;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by rodrigr1 on 1/13/2016.
 */
public class InfoDialog extends DialogFragment{

    private String mMessage;
    private String mTitle;

    public InfoDialog(){
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mMessage = getArguments().getString(ComicFragment.TAG_DIALOG_MESSAGE);
        mTitle = getArguments().getString(ComicFragment.TAG_DIALOG_TITLE);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(mMessage)
                .setTitle(mTitle);

        return builder.create();
    }

    @Override
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance())
            getDialog().setDismissMessage(null);
        super.onDestroyView();
    }

}
