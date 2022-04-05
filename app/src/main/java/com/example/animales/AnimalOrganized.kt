package com.example.animales

class AnimalOrganized {
    var listaAnimales = listOf<DataAnimales>()

    constructor(){
        listaAnimales = listOf(
            DataAnimales("Elefante", "MAMÍFEROS"),
            DataAnimales("Perro", "MAMÍFEROS"),
            DataAnimales("Gato", "MAMÍFEROS"),
            DataAnimales("Rana", "ANFIBIOS"),
            DataAnimales("Ajolote", "ANFIBIOS"),
            DataAnimales("Salamandra", "ANFIBIOS"),
            DataAnimales("Tortuga", "REPTILES"),
            DataAnimales("Caimán", "REPTILES"),
            DataAnimales("Pitón", "REPTILES"),
            DataAnimales("Tiburón", "PECES"),
            DataAnimales("Piraña", "PECES"),
            DataAnimales("Pez payaso", "PECES"),
            DataAnimales("Loro", "AVES"),
            DataAnimales("Guacamaya", "AVES"),
            DataAnimales("Colibri", "AVES"),
            DataAnimales("Mariposa", "INSECTOS"),
            DataAnimales("Mantis", "INSECTOS"),
            DataAnimales("Mariquita", "INSECTOS"),
            DataAnimales("Camarón", "ANTRÓPODOS"),
            DataAnimales("Araña", "ANTRÓPODOS"),
            DataAnimales("Cigala", "ANTRÓPODOS")

        )
    }

    public fun obtenerAnimalPorTipo(tipo : String) : ArrayList<DataAnimales>{
        var result = arrayListOf<DataAnimales>()

        for(animal in listaAnimales){
            if (animal.tipo.equals(tipo)){
               result.add(animal)
            }
        }

        return result
    }
}