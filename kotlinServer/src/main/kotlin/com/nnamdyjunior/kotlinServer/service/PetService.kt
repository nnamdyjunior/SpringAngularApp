package com.nnamdyjunior.kotlinServer.service

import com.nnamdyjunior.kotlinServer.model.Pet
import com.nnamdyjunior.kotlinServer.repository.PetRepository
import org.springframework.stereotype.Service

@Service
class PetService(val petRepository: PetRepository){
    fun getPets(): List<Pet> = petRepository.findAll()
}