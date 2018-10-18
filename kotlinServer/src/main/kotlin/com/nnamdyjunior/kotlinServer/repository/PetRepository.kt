package com.nnamdyjunior.kotlinServer.repository

import com.nnamdyjunior.kotlinServer.model.Pet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository : JpaRepository<Pet, String> {
    override fun findAll() : List<Pet>
}