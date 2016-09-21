package io.github.robwin.web.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "heroes")
data class Hero (@Id
                 @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
                 var id: Int?  = null,
                 var name: String = "")
