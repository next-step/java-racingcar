package Step3;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public int readIntegerInput(String question) {
        System.out.println(question);

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        return Integer.parseInt(value);
    }

    public String readStringInput(String question) {
        System.out.println(question);

        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public void printResult(List<List<Integer>> gameRecord, String[] carNames) {
        System.out.println("실행 결과");

        for (int i = 0; i < gameRecord.size(); i++) {
            System.out.println("[ TURN #" + (i + 1) + " ]");

             printTurnRecord(gameRecord.get(i), carNames);
        }

        System.out.println();
    }

    public void printWinner(String[] carNames, List<Integer> winnersIdx) {
        for (int i = 0; i < winnersIdx.size(); i++) {
            System.out.print(carNames[winnersIdx.get(i)]);

            printComma(winnersIdx, i);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private static void printComma(List<Integer> winnersIdx, int i) {
        if (i != winnersIdx.size() - 1) {
            System.out.print(", ");
        }
    }

    private static void printTurnRecord(List<Integer> turnRecord, String[] carNames) {
        for (int i = 0; i < turnRecord.size(); i++){
            printCarPosition(turnRecord.get(i), carNames[i]);
        }

        System.out.println();
    }

    private static void printCarPosition(Integer position, String carName) {
        System.out.print("[" + carName + "] ");

        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
