package racing.util;

import java.util.List;

public final class Printer {
    private Printer() {}

    public static void printName(final String name) {
        System.out.print(name + " : ");
    }

    public static void printMovement() {
        System.out.print("- ");
    }

    public static void printBorder() {
        System.out.println();
    }

    public static void printWinner(final List<String> winners) {
        String winner = String.join(", ", winners);
        System.out.println(winner + "가 최종 우승 했습니다.");
    }

}
