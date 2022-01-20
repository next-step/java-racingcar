package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    private Console() {}

    public static int getTurn() {
        int turn;

        System.out.println("시도할 횟수는 몇 회인가요?");
        turn = Console.readInt();
        System.out.println();

        return turn;
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.stream(
                Console.readString().split(",")
            )
            .collect(Collectors.toList());
    }

    public static void validateCarNames(List<String> carNames) {
        long carNamesLengthOver5 = carNames.stream()
            .filter(carName -> carName.length() > 5)
            .count();

        if (carNamesLengthOver5 > 0) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘길 수 없습니다.");
        }
    }

    private static int readInt() {
        return scanner.nextInt();
    }

    private static String readString() {
        return scanner.nextLine();
    }
}
