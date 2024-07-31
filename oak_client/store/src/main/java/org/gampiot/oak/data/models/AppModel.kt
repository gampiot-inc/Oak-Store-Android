package org.gampiot.oak.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppModel(
    val app_id: String,
    val app_name_app: String,
    val app_photo_app: String,
    val app_description: String,
    val app_category: String,
    val app_comments: String,
    val app_status: String,
    val app_tag: String,
    val app_download_url: String,
    val app_download_count: Int,
    val app_dev_id: String,
    val app_dev_name: String,
    val app_dev_photo: String
) : Parcelable