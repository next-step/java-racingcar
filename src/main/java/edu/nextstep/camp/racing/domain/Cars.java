package edu.nextstep.camp.racing.domain;

import edu.nextstep.camp.racing.view.OutputView;
import edu.nextstep.camp.racing.view.RacingOutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private final Random random = new Random();

    private final List<Car> cars;

    private int maxPosition;

    public Cars(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(car->{
            car.move(randomInt());

            maxPosition = car.maxPosition(maxPosition);

            RacingOutputView.printCurrentPosition(car);
        });

        // 개행
        OutputView.print("");
    }

    public List<String> winners(){
        return cars.stream()
                .filter(car->car.currentPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    protected int randomInt(){
        return random.nextInt(10);
    }
}
