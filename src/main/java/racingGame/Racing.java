package racingGame;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final Position movePolicy;

    public Racing(List<Car> cars, Position movePolicy) {
        this.cars = cars;
        this.movePolicy = movePolicy;
    }

    public List<List<CarSnapshot>> race(int rounds) {
        ResultView resultView = new ResultView();
        List<List<CarSnapshot>> timeline = new ArrayList<>();

        for (int r = 0; r < rounds; r++) {
            for (Car car : cars) car.move(movePolicy);
            List<CarSnapshot> roundSnapshot = snapshot();
            timeline.add(roundSnapshot);
            resultView.printRound(r, roundSnapshot);
        }
        return timeline;
    }

    private List<CarSnapshot> snapshot() {
        List<CarSnapshot> list = new ArrayList<>();
        for (Car c : cars) list.add(new CarSnapshot(c.getName(), c.getPosition()));
        return list;
    }

    public static class CarSnapshot {
        public final String name;
        public final int position;
        public CarSnapshot(String name, int position) {
            this.name = name;
            this.position = position;
        }
    }

    public static void main(String[] args) {
        InputView input = new InputView();
        int carCount = input.racingCars();
        int roundCount = input.rounds();

        List<Car> cars = input.getCarList(carCount);
        Position movePolicy = new Position();
        Racing game = new Racing(cars, movePolicy);
        game.race(roundCount);
    }

}
