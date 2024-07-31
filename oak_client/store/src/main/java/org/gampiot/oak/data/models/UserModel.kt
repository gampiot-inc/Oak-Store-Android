package org.gampiot.oak.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val dev_name: String,
    val dev_email: String,
    val dev_notifications: String,
    val dev_password: String,
    val dev_photo_profile: String,
    val dev_uid: String,
    val dev_followers: String,
    val dev_levels: String,
    val dev_bio: String,
    val dev_bio_urls: String
) : Parcelable