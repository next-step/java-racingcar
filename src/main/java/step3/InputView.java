package step3;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    int carCount, tryCount;

    public RacingGame run() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        setCarCount();
        System.out.println("시도할 회수는 몇 대 인가요?");
        setTryCount();
        return new RacingGame(carCount, tryCount);

    }

    public void setCarCount() {
        this.carCount = scanner.nextInt();
    }

    public void setTryCount() {
        this.tryCount = scanner.nextInt();
    }

}
