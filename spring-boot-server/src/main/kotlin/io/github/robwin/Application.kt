package io.github.robwin

import io.github.robwin.web.entity.Hero
import io.github.robwin.web.repository.HeroesRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = arrayOf(HeroesRepository::class))
@EntityScan(basePackageClasses = arrayOf(Hero::class))
open class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
