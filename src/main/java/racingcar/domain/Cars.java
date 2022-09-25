package racingcar.domain;

import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    List<Car> carList;

    public Cars(int carNum) {
        carList = Stream.generate(Car::new).limit(carNum).collect(Collectors.toList());
    }

    public void play() {
        for (Car car : carList) {
            car.move();
        }
    }

    public void printPosition() {
        ResultView.print(carList);
    }
}
