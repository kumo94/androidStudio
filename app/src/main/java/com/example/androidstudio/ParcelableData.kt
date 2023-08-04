package com.example.androidstudio

import android.os.Parcel
import android.os.Parcelable

class ParcelableData : Parcelable {
    var id: Int = 0
    var name: String? = null
    var place: String? = null

    constructor(id: Int, name: String, place: String) {
        this.id = id
        this.name = name
        this.place = place
    }

    protected constructor(`in`: Parcel) {
        id = `in`.readInt()
        name = `in`.readString()
        place = `in`.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(name)
        dest.writeString(place)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<com.example.androidstudio.ParcelableData> = object: Parcelable.Creator<com.example.androidstudio.ParcelableData> {
            override fun createFromParcel(`in`: Parcel): com.example.androidstudio.ParcelableData {
                return ParcelableData(`in`)
            }

            override fun newArray(size: Int): Array<com.example.androidstudio.ParcelableData?> {
                return arrayOfNulls(size)
            }
        }
    }
}