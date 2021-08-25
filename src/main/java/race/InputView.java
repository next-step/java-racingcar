package race;

import java.util.Scanner;

public class InputView {

    private static final String messageRegisterCar = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static final String messageGameCount = "시도할 회수는 몇 회 인가요?";

    private static int askInput() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    protected static int carRegisterInputOutput() {
        System.out.println(messageRegisterCar);
        return askInput();
    }

    protected static int gameCountInputOutput() {
        System.out.println(messageGameCount);
        return askInput();
    }

    private String[] splitInput(String input) {
        String[] carNames = input.split(",");
        return null;
    }
}
