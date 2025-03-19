package racing.view;

import racing.config.GameConfig;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public GameConfig promptForGameConfig() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = splitInput(scanner.next());
        validateInput(carNames);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int attemptCount = scanner.nextInt();

        return new GameConfig(carNames, attemptCount);
    }

    private String[] splitInput(final String input) {
        return input.split(",");
    }

    private void validateInput(final String[] carNames) {
        if(hasElementWithMoreThanFiveCharacters(carNames)){
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static boolean hasElementWithMoreThanFiveCharacters(final String[] array) {
        return Arrays.stream(array).anyMatch(str -> str.length() > 5);
    }

    public void close() {
        scanner.close();
    }
}
