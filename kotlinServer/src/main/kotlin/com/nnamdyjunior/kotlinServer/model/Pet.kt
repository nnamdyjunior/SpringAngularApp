package com.nnamdyjunior.kotlinServer.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Pet(@Id val name:String,
               val type: String,
               val age: Int)