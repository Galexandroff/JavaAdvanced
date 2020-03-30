package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Set<Integer> first = new LinkedHashSet<>();

        while(n-- > 0){
            first.add(scanner.nextInt());
        }

        Set<Integer> second = new LinkedHashSet<>();

        while(m-- > 0){
            second.add(scanner.nextInt());
        }
        first.retainAll(second);

        for (Integer integer : first) {
            System.out.print(integer + " ");
        }
    }
}
