package race.view;

import race.domain.Round;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public InputView(String input) {
        this.scanner = new Scanner(input);
    }

    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)");

        return scanner.nextLine();
    }

    public int askRoundCount() {
        System.out.println("시도할 이동 횟수는 몇 회 입니까?");

        int input;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("1 이상의 숫자만 사용할 수 있습니다.");
        }

        int minimumTrial = 1;
        if (input < minimumTrial) {
            throw new IllegalArgumentException("이동 횟수는 1회 이상으로 설정해야 합니다.");
        }

        return input;
    }
}
