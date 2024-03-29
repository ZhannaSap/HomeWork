package com.example.homework.utils

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(val context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(CONSTANTS.APP_DATA, Context.MODE_PRIVATE)

    fun setUserAuth(bool: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean(CONSTANTS.USER_AUTHED, bool)
            .apply()
    }

    fun getUserAuthed(): Boolean? {
        return sharedPreferences.getBoolean(CONSTANTS.USER_AUTHED, false)
    }
    fun setOnboardingShown() {
        sharedPreferences
            .edit()
            .putBoolean(CONSTANTS.ONBOARDING_SHOWN, true)
            .apply()
    }

    fun getOnboardingShownStatus(): Boolean? {
        return sharedPreferences.getBoolean(CONSTANTS.ONBOARDING_SHOWN, false)
    }

    fun saveName(name: String) {
        sharedPreferences
            .edit()
            .putString(CONSTANTS.PROFILE_NAME, name)
            .apply()
    }

    fun getSavedName(): String? {
        val savedName = sharedPreferences.getString(CONSTANTS.PROFILE_NAME, "default")

        return if (savedName != "default") {
            savedName
        } else {
            null
        }
    }

    fun saveLogin(login: String) {
        sharedPreferences
            .edit()
            .putString(CONSTANTS.PROFILE_LOGIN, login)
            .apply()
    }

    fun getSavedLogin(): String? {
        val savedLogin = sharedPreferences.getString(CONSTANTS.PROFILE_LOGIN, "default")

        return if (savedLogin != "default") {
            savedLogin
        } else {
            null
        }
    }

    fun saveAvatar(url: String) {
        sharedPreferences
            .edit()
            .putString(CONSTANTS.PROFILE_AVATAR, url)
            .apply()
    }

    fun getSavedAvatar(): String? {
        val savedAvatar = sharedPreferences.getString(CONSTANTS.PROFILE_AVATAR, "default")

        return if (savedAvatar != "default") {
            savedAvatar
        } else {
            null
        }
    }
}