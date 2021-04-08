package carracing.view;

import java.util.Scanner;

public class InputView {

    private final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public InputView() { }

    public String inputCarName() {
        System.out.println(INPUT_CAR_NAMES);
        return scanner.next();
    }

    public int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        return scanner.nextInt();
    }
}
