package org.example;

import java.util.List;

public class Pokemon {
    private int id;
    private String name;
    private int base_experience;
    private int height;
    private Boolean is_default;
    private int order;
    private int weight;
    private PokemonStats pokemonStats;
    private List<PokemonType> lstPokemonType;
    private List<PokemonAbility> lstPokemonAbility;
    private List<PokemonMove> lstPokemonMove;
    private List<PokemonImage> lstPokemonImage;


    public Pokemon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Boolean getIs_default() {
        return is_default;
    }

    public void setIs_default(Boolean is_default) {
        this.is_default = is_default;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public PokemonStats getPokemonStats() {
        return pokemonStats;
    }

    public void setPokemonStats(PokemonStats pokemonStats) {
        this.pokemonStats = pokemonStats;
    }

    public List<PokemonType> getLstPokemonType() {
        return lstPokemonType;
    }

    public void setLstPokemonType(List<PokemonType> lstPokemonType) {
        this.lstPokemonType = lstPokemonType;
    }

    public List<PokemonAbility> getLstPokemonAbility() {
        return lstPokemonAbility;
    }

    public void setLstPokemonAbility(List<PokemonAbility> lstPokemonAbility) {
        this.lstPokemonAbility = lstPokemonAbility;
    }

    public List<PokemonMove> getLstPokemonMove() {
        return lstPokemonMove;
    }

    public void setLstPokemonMove(List<PokemonMove> lstPokemonMove) {
        this.lstPokemonMove = lstPokemonMove;
    }

    public List<PokemonImage> getLstPokemonImage() {
        return lstPokemonImage;
    }

    public void setLstPokemonImage(List<PokemonImage> lstPokemonImage) {
        this.lstPokemonImage = lstPokemonImage;
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", base_experience=" + base_experience +
                ", height=" + height +
                ", is_default=" + is_default +
                ", order=" + order +
                ", weight=" + weight +
                ", pokemonStats=" + pokemonStats +
                ", lstPokemonType=" + lstPokemonType +
                ", lstPokemonAbility=" + lstPokemonAbility +
                ", lstPokemonMove=" + lstPokemonMove +
                ", lstPokemonImage=" + lstPokemonImage +
                '}';
    }
}
