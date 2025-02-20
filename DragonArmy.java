package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, int[]>> dragons = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String type = tokens[0];
            String name = tokens[1];

            int damage = tokens[2].equals("null")
                    ? 45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null")
                    ? 250 : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null")
                    ? 10 : Integer.parseInt(tokens[4]);

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).put(name, new int[]{damage,health,armor});
        }
        dragons.entrySet().forEach(entry -> {

            double averageDamage = entry.getValue().entrySet().stream()
                    .mapToInt(e -> e.getValue()[0])
                    .average()
                    .orElse(0.0);
            double averageHealth = entry.getValue().entrySet().stream()
                    .mapToInt(e -> e.getValue()[1])
                    .average()
                    .orElse(0.0);
            double averageArmor = entry.getValue().entrySet().stream()
                    .mapToInt(e -> e.getValue()[2])
                    .average()
                    .orElse(0.0);



            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",entry.getKey(),
                    averageDamage,averageHealth,averageArmor));

            entry.getValue().entrySet()
                    .forEach(innerEntry -> {
                        System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n"
                                ,innerEntry.getKey()
                                ,innerEntry.getValue()[0]
                                ,innerEntry.getValue()[1]
                                ,innerEntry.getValue()[2]

                        );
                    });
        });
    }
}
