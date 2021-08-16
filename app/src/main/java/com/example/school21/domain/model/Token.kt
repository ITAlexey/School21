package com.example.school21.domain.model

abstract class Token {
   companion object {
       protected const val SECRET_KEY =
           "3b0a8351fb5a528eb87280f41cfda1f0b5ce95fb300b3cac42654d7bc13189a1"
       protected const val UID = "e41ba478e4473ad51708f9c2754a57a127d57412eb933ecd37aec531111fa9f7"
       protected const val GRANT_TYPE = "client_credentials"
   }
}