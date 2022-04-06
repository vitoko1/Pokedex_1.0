package org.example;

public class PokemonStats  {



   private int hp;
   private int attack;
   private int defense;
   private int special_attack;
   private int special_defense;
   private int speed;
   private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public PokemonStats(int hp, int attack, int defense, int special_attack, int special_defense, int speed, int total) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.special_attack = special_attack;
        this.special_defense = special_defense;
        this.speed = speed;
        this.total = total;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public PokemonStats() {
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecial_attack() {
        return special_attack;
    }

    public void setSpecial_attack(int special_attack) {
        this.special_attack = special_attack;
    }

    public int getSpecial_defense() {
        return special_defense;
    }

    public void setSpecial_defense(int special_defense) {
        this.special_defense = special_defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    @Override
    public String toString() {
        return "PokemonStats{" +
                "hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", special_attack=" + special_attack +
                ", special_defense=" + special_defense +
                ", speed=" + speed +
                ", total=" + total +
                '}';
    }
}
