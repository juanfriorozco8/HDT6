import java.io.*;
import java.util.*;

public class PokemonManager {
    private Map<String, String[]> pokemonMap;
    private List<String[]> userCollection = new ArrayList<>();

    public PokemonManager(int mapType) {
        pokemonMap = MapFactory.getMap(mapType);
        loadPokemonData("pokemon_data_pokeapi.csv"); 
    }

    private void loadPokemonData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                pokemonMap.put(data[0], data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPokemon(String name) {
        if (!pokemonMap.containsKey(name)) {
            System.out.println("Error: Pokémon no encontrado.");
            return;
        }
        for (String[] p : userCollection) {
            if (p[0].equals(name)) {
                System.out.println("Este Pokémon ya está en la colección.");
                return;
            }
        }
        userCollection.add(pokemonMap.get(name));
        System.out.println(name + " agregado a la colección.");
    }

    public void showPokemon(String name) {
        if (pokemonMap.containsKey(name)) {
            System.out.println(Arrays.toString(pokemonMap.get(name)));
        } else {
            System.out.println("Pokémon no encontrado.");
        }
    }

    public void showUserCollectionSorted() {
        userCollection.stream().sorted(Comparator.comparing(p -> p[1]))
                .forEach(p -> System.out.println(p[0] + " - " + p[1]));
    }

    public void showAllPokemonsSorted() {
        pokemonMap.values().stream().sorted(Comparator.comparing(p -> p[1]))
                .forEach(p -> System.out.println(p[0] + " - " + p[1]));
    }

    public void searchByAbility(String ability) {
        pokemonMap.values().stream()
                .filter(p -> p[2].equalsIgnoreCase(ability))
                .forEach(p -> System.out.println(p[0]));
    }
}
