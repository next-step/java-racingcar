package racing;

import java.util.Scanner;

import static racing.Validate.*;

public class InputView {

    public static String[] inputCarCount() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(",");
        String carNames = scanner.nextLine();
        validInputNames(carNames);

        return carNames.split(",");
    }

    public static int inputMoveCount() {
        System.out.println("시도할 회수는 몇 회 인가요? (2 이상의 자연수 입력)");
        Scanner scanner = new Scanner(System.in);
        int moveCount = scanner.nextInt();
        validInputMoveCount(moveCount);

        return moveCount;
    }
}
