package org.example;

public class PokemonAbility {


   private String abilityName;

    public PokemonAbility( String abilityName) {

        this.abilityName = abilityName;
    }

    public PokemonAbility() {
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    @Override
    public String toString() {
        return "PokemonAbility{" +
                "abilityName='" + abilityName + '\'' +
                '}';
    }
}
