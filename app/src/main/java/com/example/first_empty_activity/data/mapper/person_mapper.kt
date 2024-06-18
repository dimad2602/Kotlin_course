package com.example.first_empty_activity.data.mapper

import com.example.first_empty_activity.data.dto.PersonDTO
import com.example.first_empty_activity.data.models.person.PersonModel

fun PersonModel.toDTO(): PersonDTO {
    return PersonDTO(firstName = this.firstName, lastName = this.lastName, age = this.age)
}

fun PersonDTO.toPerson(age: Int): PersonModel {
    return PersonModel(firstName = this.firstName, lastName = this.lastName, age = this.age)
}