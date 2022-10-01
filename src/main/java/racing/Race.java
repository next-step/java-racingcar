package racing;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars = new ArrayList<>();
    private final ArrayList<ArrayList<Integer>> scoreBoard = new ArrayList<>();
    private final int play;

    public Race(final int numberOfCars, final int numberOfPlays) {
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(createCar());
        }
        this.play = numberOfPlays;
    }

    public void play() {
        for (int i = 0; i < play; i++) {
            run();
        }
    }

    //TODO: 인터페이스로 정의
    private void run() {
        ArrayList<Integer> result = new ArrayList<>();
        for (Car car : cars) {
            car.move();
            result.add(car.location());
        }
        scoreBoard.add(result);
    }

    private Car createCar() {
        return new Car();
    }


    public ArrayList<ArrayList<Integer>> result() {
        return scoreBoard;
    }
}
