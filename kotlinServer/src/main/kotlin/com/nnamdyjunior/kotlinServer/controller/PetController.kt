package com.nnamdyjunior.kotlinServer.controller

import com.nnamdyjunior.kotlinServer.model.Pet
import com.nnamdyjunior.kotlinServer.service.PetService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mypets")
class PetController(val petService: PetService) {

    @GetMapping("/get")
    fun getPets(): List<Pet> {
        println("Heyyy"); return petService.getPets()
    }

}
