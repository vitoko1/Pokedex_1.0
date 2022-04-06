package org.example;

public class PokemonType {

    private String nameType;


    public PokemonType(String nameType) {
        this.nameType = nameType;
    }

    public PokemonType() {
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }


    @Override
    public String toString() {
        return "PokemonType{" +
                "nameType='" + nameType + '\'' +
                '}';
    }
}
