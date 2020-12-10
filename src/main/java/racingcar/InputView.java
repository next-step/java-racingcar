package racingcar;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * 차의 대수를 입력받습니다.
     */
    public RacingCarDriver inputCarAmount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return new RacingCarDriver(this.scanner.nextInt());
    }

    /**
     * 몇 회차까지 진행 할 지 입력받습니다.
     * @return round
     */
    public int inputRacingRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return this.scanner.nextInt();
    }

}
