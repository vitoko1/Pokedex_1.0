package org.example;

public class PokemonImage {

  private String front_default;
  private String back_default;


    public PokemonImage() {
    }


    public PokemonImage(String front_default, String back_default) {
        this.front_default = front_default;
        this.back_default = back_default;
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }

    public String getBack_default() {
        return back_default;
    }

    public void setBack_default(String back_default) {
        this.back_default = back_default;
    }


    @Override
    public String toString() {
        return "PokemonImage{" +
                "front_default='" + front_default + '\'' +
                ", back_default='" + back_default + '\'' +
                '}';
    }
}
