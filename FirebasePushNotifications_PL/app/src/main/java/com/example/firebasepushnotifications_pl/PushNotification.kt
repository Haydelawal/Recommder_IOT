package com.example.firebasepushnotifications_pl

import com.example.firebasepushnotifications_pl.NotificationData

data class PushNotification(
    val data: NotificationData,
    val to: String
)