package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Set<String>> playersWithCards = new LinkedHashMap<>();

        while (!line.equals("JOKER")) {
            String[] tokens = line.split(": ");
            String name = tokens[0];
            List<String> cards = Arrays.stream(tokens[1].split(", "))
                    .collect(Collectors.toList());
            playersWithCards.putIfAbsent(name, new HashSet<>());
            playersWithCards.get(name).addAll(cards);


            line = scanner.nextLine();
        }

        playersWithCards.forEach((key, value) -> {

            int power = calculatePower(value);
            System.out.printf("%s: %d%n", key, power);
        });
    }

    private static int calculatePower(Set<String> value) {
        int power = 0;

        for (String card : value) {
            power += calcCardPower(card);
        }


        return power;
    }

    private static int calcCardPower(String card) {
        int power = 0;
        char firstLetter = card.charAt(0);

        if(Character.isDigit(firstLetter)) {


            int[] powers = {0, 10, 2, 3, 4, 5, 6, 7, 8, 9};
            power += powers[card.charAt(0) - '0'];
        }else {
            switch (firstLetter){
                case 'J':
                    power += 11;
                    break;
                case 'Q':
                    power +=12;
                    break;
                case 'K':
                    power +=13;
                    break;
                case 'A':
                    power +=14;
                    break;
            }
        }


        switch (card.charAt(card.length()-1)){
            case 'S':
                power*=4;
                break;
            case 'H':
                power *=3;
                break;
            case 'D':
                power *=2;
                break;
        }
        return power;
    }

}
