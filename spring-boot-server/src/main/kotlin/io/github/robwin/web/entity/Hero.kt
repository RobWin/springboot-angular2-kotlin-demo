package io.github.robwin.web.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "heroes")
data class Hero (@Id
                 var id: Int = 0,
                 var name: String = "")
