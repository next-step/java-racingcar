package racingcar.view;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class GameOutputView {
    private static final String SHOW_DELIMITER = " : ";

    private final DistanceSymbol distanceSymbol;

    public GameOutputView(DistanceSymbol distanceSymbol) {
        this.distanceSymbol = distanceSymbol;
    }

    public void show(Cars cars) {
        for (Car car : cars) {
            showDistance(car);
        }
        System.out.println();
    }

    public void showFinish(Cars cars) {
        showWinner(cars.longest().names());
    }

    private void showWinner(List<String> winners) {
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }
    
    private void showDistance(Car car) {
        System.out.print(car.name() + SHOW_DELIMITER);
        for (int count = 0; count < car.distance(); count++) {
            System.out.print(distanceSymbol.value());
        }
        System.out.println();
    }
}


