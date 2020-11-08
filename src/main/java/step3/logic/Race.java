package step3.logic;

import step3.ui.InputView;
import step3.ui.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    private final List<Car> cars;

    public Race(int numberCars) {
        cars = IntStream.range(0, numberCars)
                .mapToObj(i -> new Car())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void lap() {
        cars.forEach(car -> car.run(car.getThrottle()));
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Race race = new Race(inputView.readNumberCars());

        for (int it = inputView.readNumberIterations(); it > 0; --it) {
            race.lap();
            outputView.showStatus(race.getCars());
            System.out.println();
        }
    }
}
