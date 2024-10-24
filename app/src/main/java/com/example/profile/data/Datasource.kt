package com.example.profile.data

import com.example.profile.R
import com.example.profile.model.Profile

class Datasource {
    fun loadAffirmations() : List<Profile> {
        return listOf<Profile>(
            Profile(R.string.profile11, R.string.profile12, R.string.profile13, R.drawable.profile),
            Profile(R.string.profile21, R.string.profile22, R.string.profile23, R.drawable.profile2),
            Profile(R.string.profile31, R.string.profile32, R.string.profile33, R.drawable.profile3),
        )
    }
}