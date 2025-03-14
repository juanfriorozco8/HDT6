import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PokemonManagerTest {
    @Test
    void testAddPokemon() {
        PokemonManager pm = new PokemonManager(1);
        pm.addPokemon("Pikachu");
        assertEquals(1, pm.userCollection.size());
    }

    @Test
    void testSearchByAbility() {
        PokemonManager pm = new PokemonManager(1);
        pm.searchByAbility("Static");
    }
}
