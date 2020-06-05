package racing.util;

import java.util.List;
import java.util.stream.Collectors;

public final class Printer {
    private Printer() {}

    public static void printName(final String name) {
        String result = String.format("%s : ", name);

        System.out.print(result);
    }

    public static void printMovement() {
        System.out.print("- ");
    }

    public static void printBorder() {
        System.out.println();
    }

    public static void printWinner(final List<String> winners) {
        String winner = winners.stream().map(Object::toString).collect(Collectors.joining(", "));
        String result = String.format("%s가 최종 우승했습니다.", winner);

        System.out.println(result);
    }

}
