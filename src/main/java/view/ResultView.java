package view;

public class ResultView {

    public static void printEachRound(String name, int distance) {
        String result = name + " : " + "-".repeat(distance);
        System.out.println(result);
    }

    public static void printWinnerName(String name) {
        System.out.print(name);
    }

    public static void printComma() {
        System.out.print(", ");
    }

    public static void announceWinner() {
        System.out.print("가 최종 우승했습니다.");
    }

    public static void printSpaceBetweenRounds() {
        System.out.println();
    }
}
