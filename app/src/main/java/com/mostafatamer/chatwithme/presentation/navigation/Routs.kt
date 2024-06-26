package com.mostafatamer.chatwithme.presentation.navigation

import com.google.gson.Gson
import com.mostafatamer.chatwithme.domain.model.dto.dto.Chat

sealed class Routs(val route: String) {

    data object SignUp : Routs("signUp")
    data object Login : Routs("login")
    data object Main : Routs("main")
    data object FriendRequests : Routs("friend_requests")
    data object FriendChat : Routs("friend_chat/{chat_dto}") {
        fun withFriend(chat: Chat): String {
            val chatJson = Gson().toJson(chat)
            return route.replace("{chat_dto}", chatJson)
        }
    }
    data object GroupChat : Routs("group_chat/{chat_dto}") {
        fun withFriend(chat: Chat): String {
            val chatJson = Gson().toJson(chat)
            return route.replace("{chat_dto}", chatJson)
        }
    }
}
