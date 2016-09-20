package io.github.robwin.web.controller

import io.github.robwin.web.dto.HeroesResponse
import io.github.robwin.web.entity.Hero
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HeroesControllerTest {

  @Autowired
  private lateinit var restTemplate: TestRestTemplate

  @Test
  fun getHeroes(){
    val heroesResponse = restTemplate.getForEntity("/api/heroes", HeroesResponse::class.java)
    assertThat(heroesResponse.statusCode).isEqualTo(HttpStatus.OK)
    assertThat(heroesResponse.body.heroes).hasSize(10)
  }

  @Test
  fun createHero(){
    val heroResponse = restTemplate.postForEntity("/api/heroes", Hero(name = "New name"), Hero::class.java)
    assertThat(heroResponse.statusCode).isEqualTo(HttpStatus.CREATED)
    assertThat(heroResponse.body).isNotNull()
    assertThat(heroResponse.body.id).isNotNull()
    assertThat(heroResponse.body.name).isEqualTo("New name")
    assertThat(heroResponse.headers["location"]).isNotNull()

    val heroesResponse = restTemplate.getForEntity("/api/heroes", HeroesResponse::class.java)
    assertThat(heroesResponse.body.heroes).hasSize(11)
  }

  @Test
  fun getHeroById(){
    val heroResponse = restTemplate.getForEntity("/api/heroes/{id}", Hero::class.java, 1)
    assertThat(heroResponse.statusCode).isEqualTo(HttpStatus.OK)
    assertThat(heroResponse.body).isNotNull()
    assertThat(heroResponse.body.id).isEqualTo(1)
    assertThat(heroResponse.body.name).isEqualTo("Mr. Nice")
  }

  @Test
  fun deleteHeroById(){
    restTemplate.delete("/api/heroes/{id}", 2)
    val heroResponse = restTemplate.getForEntity("/api/heroes/{id}", Hero::class.java, 2)
    assertThat(heroResponse.body).isNotNull()
    assertThat(heroResponse.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
  }

  @Test
  fun updateHero(){
    restTemplate.put("/api/heroes/{id}", Hero(3, "Updated name"), 3)
    val heroResponse = restTemplate.getForEntity("/api/heroes/{id}", Hero::class.java, 3)
    assertThat(heroResponse.statusCode).isEqualTo(HttpStatus.OK)
    assertThat(heroResponse.body.id).isEqualTo(3)
    assertThat(heroResponse.body.name).isEqualTo("Updated name")
  }
}
