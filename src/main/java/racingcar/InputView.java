package racingcar;

import java.util.Scanner;

public class InputView {
    private String carNames;
    private int trialCount;


    public Racing init() {
        Scanner scanner = new Scanner(System.in);

        carNames = getCarNames(scanner);
        trialCount = getTrialCount(scanner);

        return new Racing(carNames, trialCount);
    }

    private String getCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    private static Integer getTrialCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTrialCount() {
        return trialCount;
    }
}
