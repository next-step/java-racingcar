package racing.car.ui;

import java.util.Scanner;

public class InputView {

    private static final String CAR_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_QUESTION = "시도할 횟수는 몇 회 인가요?";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputCar() {
        return splitTry(scanner.next());
    }

    public int inputTry() {
        return scanner.nextInt();
    }

    public String[] splitTry(String tryInput) {
        return tryInput.split(",");
    }

    public void carQuestion() {
        System.out.println(CAR_QUESTION);
    }

    public void tryQuestion() {
        System.out.println(TRY_QUESTION);
    }
}
