package thailand.thathiew.pattanapong.greenhouse;

import android.os.Parcel;
import android.os.Parcelable;

public class SignalModel implements Parcelable {


    private int Signal;

    public SignalModel() {
    }

    public SignalModel(int signal) {
        Signal = signal;
    }

    protected SignalModel(Parcel in) {
        Signal = in.readInt();
    }

    public static final Creator<SignalModel> CREATOR = new Creator<SignalModel>() {
        @Override
        public SignalModel createFromParcel(Parcel in) {
            return new SignalModel(in);
        }

        @Override
        public SignalModel[] newArray(int size) {
            return new SignalModel[size];
        }
    };

    public int getSignal() {
        return Signal;
    }

    public void setSignal(int signal) {
        Signal = signal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Signal);
    }
}
