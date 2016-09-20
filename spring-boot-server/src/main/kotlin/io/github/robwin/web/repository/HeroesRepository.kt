package io.github.robwin.web.repository

import io.github.robwin.web.entity.Hero
import org.springframework.data.jpa.repository.JpaRepository

interface HeroesRepository : JpaRepository<Hero, Int>
