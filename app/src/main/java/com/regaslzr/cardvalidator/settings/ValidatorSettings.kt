package com.regaslzr.cardvalidator.settings

import java.util.*

val CVC_LENGTH_MAX : Int = 4
val CVC_LENGTH_MIN : Int = 3

val CARD_NUMBER_LENGTH_MAX : Int = 19
val CARD_NUMBER_LENGTH_MIN : Int = 12

val CARD_EXP_MONTH_MAX : Int = 12
val CARD_EXP_MONTH_MIN : Int = 1

val CARD_EXP_YEAR_LENGTH = 4

val CURRENT_MONTH : Int = Calendar.getInstance().get(Calendar.MONTH)
val CURRENT_YEAR : Int = Calendar.getInstance().get(Calendar.YEAR)