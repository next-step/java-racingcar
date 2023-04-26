package racing.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static List<String> carNameList;
    private static int moveCount;

    public static void input() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String carNames = scanner.nextLine();
        carNameList = stringToNameList(carNames);

        System.out.println("시도할 회수는 몇 회 인가요?");
        moveCount = scanner.nextInt();
    }

    private static List<String> stringToNameList(String carNames) {
        return List.of(carNames.split(","));
    }

    public static List<String> carNames() {
        return carNameList;
    }

    public static int moveCount() {
        return moveCount;
    }

}
