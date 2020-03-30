package SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Fourth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] line = scanner.nextLine().toCharArray();

        Map<Character, Integer> table = new TreeMap<>();

        for (char c: line) {
            table.putIfAbsent(c,0);
            table.put(c,table.get(c) +1);
        }

        table.forEach((k,v) -> {
            System.out.printf("%c: %d time/s%n",k,v);
        });
    }
}
