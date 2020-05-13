package racing.view;

import racing.dto.RacingCreateDto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private int carCount;
    private int totalRacingCount;

    public RacingCreateDto input() {
        this.inputCarCount();
        this.inputTotalRacingCount();
        return new RacingCreateDto(this.totalRacingCount, this.carCount);
    }

    private void inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carCount = this.scanner.nextInt();
    }

    private void inputTotalRacingCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.totalRacingCount = this.scanner.nextInt();
    }
}
