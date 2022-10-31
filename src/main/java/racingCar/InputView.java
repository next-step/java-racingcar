package racingCar;

import java.util.Scanner;

public class InputView {
    private static InputView inputView = new InputView();
    private final Scanner scanner = new Scanner(System.in);
    public static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
    }

    public static InputView getInputView() {
        return inputView;
    }

    public String[] nameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return split(scanner.nextLine());
    }

    private String[] split(String input) {
        return input.split(CAR_NAME_DELIMITER);
    }


    public int numberOfRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
