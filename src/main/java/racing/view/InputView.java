package racing.view;

import racing.dto.RaceInformation;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private String[] carNames;
    private int totalRacingCount;

    public RaceInformation createByUserInput() {
        this.inputCarNames();
        this.inputTotalRacingCount();
        return new RaceInformation(this.totalRacingCount, this.carNames);
    }

    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        this.carNames = this.scanner.nextLine().split(DELIMITER);
    }

    private void inputTotalRacingCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.totalRacingCount = this.scanner.nextInt();
    }
}
