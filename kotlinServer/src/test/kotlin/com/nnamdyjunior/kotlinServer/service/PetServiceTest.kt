package com.nnamdyjunior.kotlinServer.service

import com.nnamdyjunior.kotlinServer.model.Pet
import com.nnamdyjunior.kotlinServer.repository.PetRepository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import java.util.Collections.singletonList

@SpringBootTest
@RunWith(SpringRunner::class)
class PetServiceTest {

    @MockBean
    lateinit var petRepository: PetRepository

    @Autowired
    lateinit var petService: PetService

    @Before
    fun setUp() {
    }

    @Test
    fun getPets_returnsListOfPets() {
        val jack = Pet("jack", "dog", 3)
        `when`(petRepository.findAll()).thenReturn(singletonList(jack))
        var myPets = petService.getPets()
        verify(petRepository, atLeastOnce()).findAll()
        assertTrue(myPets.equals(singletonList(jack)))
    }
}