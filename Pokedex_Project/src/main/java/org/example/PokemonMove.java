package org.example;

public class PokemonMove  {

   private String moveName;

    public PokemonMove() {
    }


    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    @Override
    public String toString() {
        return "PokemonMove{" +
                "moveName='" + moveName + '\'' +
                '}';
    }
}
