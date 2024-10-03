package racing.car.ui;

import java.util.Scanner;

public class InputView {

    private static final String CAR_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_QUESTION = "시도할 횟수는 몇 회 인가요?";
    private static final String OVER_ERROR_MESSAGE = "이름은 5글자 미만으로 입력해주세요.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputCar() {
        String[] carNames = splitTry(scanner.next());
        for (String name : carNames) {
            checkOverNumberCharacters(name);
        }
        return carNames;
    }

    public int inputTry() {
        return scanner.nextInt();
    }

    public String[] splitTry(String tryInput) {
        return tryInput.split(",");
    }

    private String checkOverNumberCharacters(String name) {
        if (name.length() >= 5) {
            throw new RuntimeException(OVER_ERROR_MESSAGE);
        }
        return name;
    }

    public void carQuestion() {
        System.out.println(CAR_QUESTION);
    }

    public void tryQuestion() {
        System.out.println(TRY_QUESTION);
    }
}
