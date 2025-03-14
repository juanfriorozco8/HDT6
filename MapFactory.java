import java.util.*;

public class MapFactory {
    public static Map<String, String[]> getMap(int option) {
        return switch (option) {
            case 1 -> new HashMap<>();
            case 2 -> new TreeMap<>();
            case 3 -> new LinkedHashMap<>();
            default -> throw new IllegalArgumentException("Opción inválida");
        };
    }
}