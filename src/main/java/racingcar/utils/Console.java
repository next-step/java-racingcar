package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    private Console() {
    }

    private static int readInt() {
        return scanner.nextInt();
    }

    private static String readString() {
        return scanner.nextLine();
    }

    public static int getTurn() {
        int turn;

        System.out.println("시도할 횟수는 몇 회인가요?");
        turn = Console.readInt();
        System.out.println();

        return turn;
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carNames = new ArrayList<>();
        for (String carName: Console.readString().split(",")) {
            carNames.add(carName);
        }

        return carNames;
    }
}
