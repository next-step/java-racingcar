package racingcar;

import java.util.Scanner;

public class InputView {

    private UserInput input;
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    void createInput() {
        this.input = new UserInput(enterCarNames(), enterrunCount());
    }

    private String enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String carNames = scanner.nextLine();
        if (carNames == null || "".equals(carNames.trim())) {
            throw new IllegalArgumentException("자동차 이름을 적어도 한개 입력해주세요.");
        }
        return carNames;
    }

    private int enterrunCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public UserInput getInput() {
        return input;
    }
}
