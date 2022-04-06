package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.apache.commons.io.IOUtils;


import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static final String APIURL = "https://pokeapi.co/api/v2/pokemon/";

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 364, 507);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Describe what is doing this method
     *
     * @param fxml
     * @throws IOException
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws IOException {

        callApiById("1");
        fetchPokemonByLimit(150);
        //System.out.println(fetchPokemonByLimit(150));
        launch();
    }


    public static Pokemon callApiById(String pokemonID) throws IOException {


        String url_string = APIURL + pokemonID + "/";

        URL url = new URL(url_string.trim());

        ObjectMapper mapper = new ObjectMapper();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();

        String result = IOUtils.toString(responseStream, StandardCharsets.UTF_8);
        JsonNode jsonNode = mapper.readTree(result);

        String name = jsonNode.get("name").asText();
        int id = jsonNode.get("id").asInt();
        int height = jsonNode.get("height").asInt();
        int weight = jsonNode.get("weight").asInt();


        // Pokemon type
        final JsonNode arrNode = new ObjectMapper().readTree(result).get("types");
        List<PokemonType> lstPokemonType = new ArrayList<PokemonType>();
        for (JsonNode j : arrNode) {
            PokemonType pkm = new PokemonType();
            pkm.setNameType(j.get("type").get("name").asText());
            lstPokemonType.add(pkm);
        }


        Pokemon pokemon = new Pokemon();
        pokemon.setId(id);
        pokemon.setHeight(height);
        pokemon.setWeight(weight);
        pokemon.setName(name);
        pokemon.setLstPokemonType(lstPokemonType);


        // Pokemon stats
        PokemonStats pkm_stats = new PokemonStats();
        int total=0;
        final JsonNode statNode = new ObjectMapper().readTree(result).get("stats");
        int counter = 0;
        for (JsonNode j : statNode) {
            if (counter == 0) {


                pkm_stats.setHp(j.get("base_stat").asInt());
                total=total+j.get("base_stat").asInt();
                counter++;
            } else if (counter == 1) {

                pkm_stats.setAttack(j.get("base_stat").asInt());
                total=total+j.get("base_stat").asInt();
                counter++;

            } else if (counter == 2) {


                pkm_stats.setDefense(j.get("base_stat").asInt());
                total=total+j.get("base_stat").asInt();
                counter++;

            } else if (counter == 3) {


                pkm_stats.setSpecial_attack(j.get("base_stat").asInt());
                total=total+j.get("base_stat").asInt();
                counter++;

            } else if (counter == 4) {


                pkm_stats.setSpecial_defense(j.get("base_stat").asInt());
                total=total+j.get("base_stat").asInt();
                counter++;

            } else if (counter == 5) {


                pkm_stats.setSpeed(j.get("base_stat").asInt());
                total=total+j.get("base_stat").asInt();
                counter++;

            }


        }
        pkm_stats.setTotal(total);
        pokemon.setPokemonStats(pkm_stats);


        //Pokemon Moves

        final JsonNode moveNode = new ObjectMapper().readTree(result).get("moves");
        List<PokemonMove> lstPokemonMove = new ArrayList<PokemonMove>();
        for (JsonNode j : moveNode) {
            PokemonMove pkmm = new PokemonMove();
            pkmm.setMoveName(j.get("move").get("name").asText());
            lstPokemonMove.add(pkmm);
        }

        pokemon.setLstPokemonMove(lstPokemonMove);

        //Pokemon Images
        PokemonImage pkImage = new PokemonImage();
        List<PokemonImage> lstPokemonImage = new ArrayList<>();
        final JsonNode imageNode = new ObjectMapper().readTree(result).get("sprites");

        pkImage.setBack_default(imageNode.get("back_default").asText());
        pkImage.setFront_default(imageNode.get("front_default").asText());

        lstPokemonImage.add(pkImage);
        pokemon.setLstPokemonImage(lstPokemonImage);


        //Pokemon Ability

        List<PokemonAbility> lstPokemonAbilities = new ArrayList<>();
        final JsonNode abilityNode = new ObjectMapper().readTree(result).get("abilities");
        for (JsonNode j : abilityNode) {
            PokemonAbility pokemonAbility = new PokemonAbility();
            pokemonAbility.setAbilityName(j.get("ability").get("name").asText());
            lstPokemonAbilities.add(pokemonAbility);
        }

        pokemon.setLstPokemonAbility(lstPokemonAbilities);

        System.out.println("ID :" + pokemon.getId());
        System.out.println("Name :" + pokemon.getName());
        System.out.println("Height :" + pokemon.getHeight());
        System.out.println("Weight :" + pokemon.getWeight());

        System.out.println("ABILITIES" + pokemon.getLstPokemonAbility().toString());
        System.out.println("IMAGES" + pokemon.getLstPokemonImage().toString());
        System.out.println("MOVES" + pokemon.getLstPokemonMove().toString());
        System.out.println("Stats" + pokemon.getPokemonStats().toString());
        System.out.println("Types" + pokemon.getLstPokemonType().toString());

        return pokemon;
    }

    

    public static List<Pokemon> fetchPokemonByLimit(int limit) throws IOException {
        String url_string = APIURL + "?limit=" + limit;

        URL url = new URL(url_string.trim());

        ObjectMapper mapper = new ObjectMapper();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();

        // get results for multiple pokemons specified by limit argument.
        String results = IOUtils.toString(responseStream, StandardCharsets.UTF_8);
        JsonNode jsonNodes = mapper.readTree(results).get("results");

        List<Pokemon> listOfPokemon = new ArrayList<>();

        // get individual api information from results for each pokemon
        for (JsonNode node : jsonNodes) {
            url = new URL(node.get("url").toString().replace("\"",  ""));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            responseStream = connection.getInputStream();

            String resultForIndividualPokemon = IOUtils.toString(responseStream, StandardCharsets.UTF_8);
            JsonNode jsonNodeForAPokemon = mapper.readTree(resultForIndividualPokemon);

            int id = jsonNodeForAPokemon.get("id").asInt();
            String name = jsonNodeForAPokemon.get("name").toString();
            int height = jsonNodeForAPokemon.get("height").asInt();
            int weight = jsonNodeForAPokemon.get("weight").asInt();


            // Pokemon type
            JsonNode arrNode = new ObjectMapper().readTree(resultForIndividualPokemon).get("types");
            List<PokemonType> lstPokemonType = new ArrayList<PokemonType>();
            for (JsonNode j : arrNode) {
                PokemonType pkm = new PokemonType();
                pkm.setNameType(j.get("type").get("name").asText());
                lstPokemonType.add(pkm);
            }

            // Pokemon stats
            PokemonStats pkm_stats = new PokemonStats();
            int total=0;
            final JsonNode statNode = new ObjectMapper().readTree(resultForIndividualPokemon).get("stats");
            int counter = 0;
            for (JsonNode j : statNode) {
                if (counter == 0) {
                    pkm_stats.setHp(j.get("base_stat").asInt());
                    total=total+j.get("base_stat").asInt();
                    counter++;
                } else if (counter == 1) {
                    pkm_stats.setAttack(j.get("base_stat").asInt());
                    total=total+j.get("base_stat").asInt();
                    counter++;
                } else if (counter == 2) {
                    pkm_stats.setDefense(j.get("base_stat").asInt());
                    total=total+j.get("base_stat").asInt();
                    counter++;
                } else if (counter == 3) {
                    pkm_stats.setSpecial_attack(j.get("base_stat").asInt());
                    total=total+j.get("base_stat").asInt();
                    counter++;
                } else if (counter == 4) {
                    pkm_stats.setSpecial_defense(j.get("base_stat").asInt());
                    total=total+j.get("base_stat").asInt();
                    counter++;
                } else if (counter == 5) {
                    pkm_stats.setSpeed(j.get("base_stat").asInt());
                    total=total+j.get("base_stat").asInt();
                    counter++;
                }
            }
            pkm_stats.setTotal(total);


            //Pokemon Moves
            final JsonNode moveNode = new ObjectMapper().readTree(resultForIndividualPokemon).get("moves");
            List<PokemonMove> lstPokemonMove = new ArrayList<PokemonMove>();
            for (JsonNode j : moveNode) {
                PokemonMove pkmm = new PokemonMove();
                pkmm.setMoveName(j.get("move").get("name").asText());
                lstPokemonMove.add(pkmm);
            }


            //Pokemon Images
            PokemonImage pkImage = new PokemonImage();
            List<PokemonImage> lstPokemonImage = new ArrayList<>();
            final JsonNode imageNode = new ObjectMapper().readTree(resultForIndividualPokemon).get("sprites");

            pkImage.setBack_default(imageNode.get("back_default").asText());
            pkImage.setFront_default(imageNode.get("front_default").asText());

            lstPokemonImage.add(pkImage);


            //Pokemon Ability
            List<PokemonAbility> lstPokemonAbilities = new ArrayList<>();
            final JsonNode abilityNode = new ObjectMapper().readTree(resultForIndividualPokemon).get("abilities");
            for (JsonNode j : abilityNode) {
                PokemonAbility pokemonAbility = new PokemonAbility();
                pokemonAbility.setAbilityName(j.get("ability").get("name").asText());
                lstPokemonAbilities.add(pokemonAbility);
            }

            System.out.println(jsonNodeForAPokemon.get("id"));
            System.out.println(jsonNodeForAPokemon.get("name"));
            System.out.println(jsonNodeForAPokemon.get("height"));
            System.out.println(jsonNodeForAPokemon.get("weight"));
            System.out.println(lstPokemonType);
            System.out.println(pkm_stats);
            System.out.println(lstPokemonMove);
            System.out.println(lstPokemonImage);
            System.out.println(lstPokemonAbilities);

            // set for pokemon object
            Pokemon pokemon = new Pokemon();
            pokemon.setName(name);
            pokemon.setId(id);
            pokemon.setHeight(height);
            pokemon.setWeight(weight);
            pokemon.setLstPokemonType(lstPokemonType);
            pokemon.setPokemonStats(pkm_stats);
            pokemon.setLstPokemonMove(lstPokemonMove);
            pokemon.setLstPokemonImage(lstPokemonImage);
            pokemon.setLstPokemonAbility(lstPokemonAbilities);


            listOfPokemon.add(pokemon);
        }

        return listOfPokemon;
    }


}