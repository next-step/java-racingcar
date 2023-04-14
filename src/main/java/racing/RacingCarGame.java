package racing;

public class RacingCarGame {

    private static int round = 0;

    public static Cars start() {
        InputView.input();
        Cars cars = new Cars(InputView.carCount(), InputView.moveCount());
        return progress(cars); // 테스트를 위해 리턴
    }

    private static Cars progress(Cars cars) {
        for (int i = 0; i < cars.moveCount(); i++) {
            cars = cars.move();
            ResultView.print(cars, round);
            round += 1;
        }
        return cars;
    }

}
