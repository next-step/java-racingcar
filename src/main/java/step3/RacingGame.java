package step3;

import java.util.List;

public class RacingGame extends Game {

    private static final int RANDOM_BOUND = 10;

    private RandomUtil randomUtil;
    private List<Car> cars;

    public RacingGame(List<Car> cars, int numberOfTry) {
        super(numberOfTry);
        this.randomUtil = new RandomUtil(RANDOM_BOUND);
        this.cars = cars;
    }

    @Override
    protected void playRound() {
        moveAllCar();
        ResultView.printRoundResult(this.cars);
    }

    private void moveAllCar() {
        this.cars.stream().forEach(car -> car.move(randomUtil.random()));
    }

}
