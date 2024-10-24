package com.example.profile.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

data class Profile(
    @StringRes val stringResourceNIMId: Int,
    @StringRes val stringResourceNameId: Int,
    @StringRes val stringResourceAddressId: Int,
    @DrawableRes val imageResourceId: Int
)
