package racing.car.ui;

import racing.car.car.Car;
import racing.car.car.Cars;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void outputView(Cars cars) {
        cars.draw();
    }

    public void outputWinnerView(List<Car> winners) {
        String winnerNames = winners.stream()
                        .map(Car::toString)
                                .collect(Collectors.joining(","));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

}
