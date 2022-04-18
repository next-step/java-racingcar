package racingcar.view;

import racingcar.domain.CarCount;
import racingcar.domain.TryCount;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private CarCount carCount;
    private TryCount tryCount;

    public InputView() {
        setCarCount();
        setTryCount();
    }

    private void setTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCountInput = scanner.nextInt();
        tryCount = new TryCount(tryCountInput);
    }

    private void setCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCountInput = scanner.nextInt();
        carCount = new CarCount(carCountInput);
    }

    public int getCarCount() {
        return carCount.carCount;
    }

    public int getTryCount() {
        return tryCount.tryCount;
    }

}
