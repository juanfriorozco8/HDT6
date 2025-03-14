import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación del MAP: 1) HashMap, 2) TreeMap, 3) LinkedHashMap");
        int choice = scanner.nextInt();
        scanner.nextLine();
        PokemonManager manager = new PokemonManager(choice);

        while (true) {
            System.out.println("1. Agregar Pokémon\n2. Mostrar Pokémon\n3. Mostrar colección ordenada\n4. Mostrar todos ordenados\n5. Buscar por habilidad\n6. Salir");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> {
                    System.out.println("Ingrese el nombre del Pokémon:");
                    manager.addPokemon(scanner.nextLine());
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre del Pokémon:");
                    manager.showPokemon(scanner.nextLine());
                }
                case 3 -> manager.showUserCollectionSorted();
                case 4 -> manager.showAllPokemonsSorted();
                case 5 -> {
                    System.out.println("Ingrese la habilidad:");
                    manager.searchByAbility(scanner.nextLine());
                }
                case 6 -> {
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}
