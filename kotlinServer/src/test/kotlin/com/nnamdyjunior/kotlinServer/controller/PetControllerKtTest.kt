package com.nnamdyjunior.kotlinServer.controller

import com.nnamdyjunior.kotlinServer.KotlinServerApplication
import com.nnamdyjunior.kotlinServer.model.Pet
import com.nnamdyjunior.kotlinServer.repository.PetRepository
import com.nnamdyjunior.kotlinServer.service.PetService
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import javax.transaction.Transactional

@SpringBootTest(
        classes = [PetController::class, KotlinServerApplication::class, PetService::class, PetRepository::class]
)
@RunWith(SpringRunner::class)
@DataJpaTest
@AutoConfigureMockMvc
@Transactional
class PetControllerKtTest{

    @Autowired lateinit var  mockMvc:MockMvc
    @Autowired lateinit var petRepository: PetRepository
    @Autowired lateinit var petService: PetService

//    @MockBean lateinit var petRepository:PetRepository
//    @MockBean lateinit var petService: PetService

//    @Before
//    fun setUp() {
//        val jimmy = Pet("Jimmy", "Dog", 7)
//        val suzie = Pet("Suzie", "Cat", 3)
//
//        petRepository.save(jimmy)
//        petRepository.save(suzie)
//    }
//
//    @After
//    fun tearDown() {
//        petRepository.deleteAll()
//    }

    @Test
    fun getPets_returnsListOfPets() {
        mockMvc.perform(get("/mypets/get"))
                .andExpect(status().is2xxSuccessful)
    }
}

