package android.os;

public interface Parcelable {
    public interface Creator<T> {
        T createFromParcel(Parcel var1);

        T[] newArray(int var1);
    }

    public interface ClassLoaderCreator<T> extends Parcelable.Creator<T> {
        T createFromParcel(Parcel var1, ClassLoader var2);
    }
}
