package edu.rosehulman.rodrigr1.comicviewer;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rodrigr1 on 1/13/2016.
 */
public class ComicWrapper implements Parcelable{
    private int xkcdIssue;
    private int color;
    private Comic comic;

    public ComicWrapper(int color){
        this.xkcdIssue = Utils.getRandomCleanIssue();
        this.color = color;
    }

    protected ComicWrapper(Parcel in) {
        xkcdIssue = in.readInt();
        color = in.readInt();
    }

    public static final Creator<ComicWrapper> CREATOR = new Creator<ComicWrapper>() {
        @Override
        public ComicWrapper createFromParcel(Parcel in) {
            return new ComicWrapper(in);
        }

        @Override
        public ComicWrapper[] newArray(int size) {
            return new ComicWrapper[size];
        }
    };

    public int getXkcdIssue() {
        return xkcdIssue;
    }

    public int getColor(){
        return color;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(xkcdIssue);
        dest.writeInt(color);
    }
}
