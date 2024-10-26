package Step3;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public int readInput(String question) {
        System.out.println(question);

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        return Integer.parseInt(value);
    }

    public void printResult(List<List<Integer>> gameRecord) {
        System.out.println("실행 결과");

        for (int i = 0; i < gameRecord.size(); i++) {
            System.out.println("[ TURN #" + (i + 1) + " ]");

             printTurnRecord(gameRecord.get(i));
        }

        System.out.println();
    }

    private static void printTurnRecord(List<Integer> turnRecord) {
        int carIdx = 0;

        for (Integer position : turnRecord) {
            printCarPosition(position, carIdx);
            carIdx++;
        }

        System.out.println();
    }

    private static void printCarPosition(Integer position, int carIdx) {
        System.out.print("[" + carIdx + "] ");

        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
