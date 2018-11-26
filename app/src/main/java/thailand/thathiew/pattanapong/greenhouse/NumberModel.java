package thailand.thathiew.pattanapong.greenhouse;

import android.os.Parcel;
import android.os.Parcelable;

public class NumberModel implements Parcelable {

    private int numberAnInt;

    public NumberModel() {
    }  // Contructor Getter

    public NumberModel(int numberAnInt) {
        this.numberAnInt = numberAnInt;
    } // Contructor Setter


    protected NumberModel(Parcel in) {
        numberAnInt = in.readInt();
    }

    public static final Creator<NumberModel> CREATOR = new Creator<NumberModel>() {
        @Override
        public NumberModel createFromParcel(Parcel in) {
            return new NumberModel(in);
        }

        @Override
        public NumberModel[] newArray(int size) {
            return new NumberModel[size];
        }
    };

    public int getNumberAnInt() {
        return numberAnInt;
    }

    public void setNumberAnInt(int numberAnInt) {
        this.numberAnInt = numberAnInt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numberAnInt);
    }
}
