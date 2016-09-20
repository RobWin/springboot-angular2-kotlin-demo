package io.github.robwin.web.controller

import io.github.robwin.web.dto.HeroesResponse
import io.github.robwin.web.entity.Hero
import io.github.robwin.web.exception.HeroNotFoundException
import io.github.robwin.web.repository.HeroesRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@Component
//@CrossOrigin(origins = arrayOf("http://localhost:3000"))
@RequestMapping(value = "/api")
class HerosController(val heroesRepository: HeroesRepository) {

    @GetMapping(value = "/heroes")
    fun getHeroes() = HeroesResponse(heroesRepository.findAll())

    @GetMapping(value = "/heroes/{id}")
    fun getHeroById(@PathVariable("id") id: Int) = heroesRepository.findOne(id) ?: throw HeroNotFoundException("Hero with id: $id not found")

    @DeleteMapping(value = "/heroes/{id}")
    fun deleteHeroById(@PathVariable("id") id: Int): ResponseEntity<Void>{
      heroesRepository.delete(id)
      return ResponseEntity.noContent().build()
    }

    @PutMapping(value = "/heroes/{id}")
    fun updateHero(@PathVariable("id") id: Int,
                   @RequestBody hero: Hero) = heroesRepository.save(hero)

    @PostMapping(value = "/heroes")
    fun createHero(@RequestBody hero: Hero, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<Hero>{
      val savedHero = heroesRepository.save(hero)
      val location = uriComponentsBuilder.path("/heroes/{id}").buildAndExpand(savedHero.id).toUri()
      return ResponseEntity.created(location).body(savedHero)
    }
}
