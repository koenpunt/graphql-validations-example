package com.example.graphqlvalidations.controllers

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

data class CustomerDetailsInput(
    @field:NotBlank
    @field:Size(min = 2, max = 255)
    val name: String,
    @field:NotBlank
    @field:Size(min = 5, max = 254)
    val email: String,
    val phoneNumber: String?,
    val locale: String? = null,
    @field:Valid
    val deliveryDetails: DeliveryDetailsInput? = null,
)

data class DeliveryDetailsInput(
    @field:NotBlank
    val streetAddress: String,
    @field:NotBlank
    val postalCode: String,
    @field:NotBlank
    val city: String,
    @field:Size(min = 2, max = 2)
    val countryCode: String,
    val additionalDescription: String? = null,
)

@Controller
class ExampleController {
    @MutationMapping
    suspend fun createCustomerDetails(
        @Valid @Argument input: CustomerDetailsInput
    ) {
        TODO("not implemented")
    }
}
