package racingcar;

public class ResultView {
    private static final String LINE = "-";
    private static final String result = "실행 결과";

    private final Cars cars;
    private int tryCount;

    public ResultView(int askTryCount, Cars cars) {
        this.tryCount = askTryCount;
        this.cars = cars;
    }

    public void printResult() {
        System.out.println(result);
        while (tryCount > 0) {
            for(int i = 0; i < cars.getCarsSize(); i ++) {
                Car car = cars.getCars().get(i);
                car.move();
                System.out.println();
                for(int j = 0; j < car.getPosition(); j ++) {
                    System.out.print(LINE);
                }
            }
            System.out.println();
            tryCount --;
        }
    }
}
