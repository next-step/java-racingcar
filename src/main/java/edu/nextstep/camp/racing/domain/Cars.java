package edu.nextstep.camp.racing.domain;

import edu.nextstep.camp.racing.view.OutputView;
import edu.nextstep.camp.racing.view.RacingOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

    private Random random = new Random(10);

    private List<Car> cars;

    public Cars(String ...carNames) {
        cars = Arrays.stream(carNames)
                .map((carName)-> new Car(carName))
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(car->{
            car.move(randomInt());
            RacingOutputView.printCurrentPosition(car);
        });
    }

    protected int randomInt(){
        return random.nextInt();
    };






}
