package thailand.thathiew.pattanapong.greenhouse;

import android.os.Parcel;
import android.os.Parcelable;

public class DateTimeModel implements Parcelable{




    private  String DateTime;
    private int NumBerAnInt;

    public DateTimeModel() {
    }


    public DateTimeModel(String dateTime, int numBerAnInt) {
        DateTime = dateTime;
        NumBerAnInt = numBerAnInt;
    }


    protected DateTimeModel(Parcel in) {
        DateTime = in.readString();
        NumBerAnInt = in.readInt();
    }

    public static final Creator<DateTimeModel> CREATOR = new Creator<DateTimeModel>() {
        @Override
        public DateTimeModel createFromParcel(Parcel in) {
            return new DateTimeModel(in);
        }

        @Override
        public DateTimeModel[] newArray(int size) {
            return new DateTimeModel[size];
        }
    };

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getNumBerAnInt() {
        return NumBerAnInt;
    }

    public void setNumBerAnInt(int numBerAnInt) {
        NumBerAnInt = numBerAnInt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(DateTime);
        dest.writeInt(NumBerAnInt);
    }
}
