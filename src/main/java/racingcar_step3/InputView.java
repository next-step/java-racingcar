package racingcar_step3;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private int racingCarCount;
    private int racingCount;

    public void input() {
        this.inputRacingCarCount();
        this.inputRacingCount();
    }

    private void inputRacingCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.racingCarCount = Integer.parseInt(scanner.nextLine());
    }

    private void inputRacingCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.racingCount = Integer.parseInt(scanner.nextLine());
    }

    public int getRacingCarCount() {
        return this.racingCarCount;
    }

    public int getRacingCount() {
        return this.racingCount;
    }
}

