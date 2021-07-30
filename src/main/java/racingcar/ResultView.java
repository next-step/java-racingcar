package racingcar;

import racingcar.util.RandomGenerator;

public class ResultView {
    private static final String RESULT = "실행 결과";
    private static final String LINE = "-";

    private final Cars cars;
    private int tryCount;

    public ResultView(int askTryCount, Cars cars) {
        this.tryCount = askTryCount;
        this.cars = cars;
    }

    public void printResult() {
        System.out.println(RESULT);
        while (tryCount > 0) {
            printLine();
            System.out.println();
            tryCount --;
        }
    }

    private void printLine() {
        for(int i = 0; i < cars.getCarsSize(); i ++) {
            Car car = cars.getCars().get(i);
            car.move(new RandomNumberMovingStrategy(new RandomGenerator()));
            System.out.println();
            for(int j = 0; j < car.getPosition(); j ++) {
                System.out.print(LINE);
            }
        }
    }
}
