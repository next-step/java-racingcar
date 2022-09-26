package ThirdStep;

import ThirdStep.interfaces.MovingCondition;
import ThirdStep.model.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarAction {
    private static final String LOCATION_SIGN = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void move(Car car, MovingCondition movingCondition) {
        if (movingCondition.canMoveForward()) {
            car.setLocation(car.getLocation() + 1);
        }
    }

    public void printLocation(Car car) {
        TextPrinter.println(String.format("%s : %s", car.getName(), LOCATION_SIGN.repeat(car.getLocation())));
    }

    public void printWinner(List<Car> cars) {
        List<Car> winners = this.getWinners(cars);
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(WINNER_DELIMITER));
        TextPrinter.println(String.format("%s가 최종 우승했습니다.", winnerNames));
    }

    private List<Car> getWinners(List<Car> cars) {
        List<Integer> locations = cars.stream().map(Car::getLocation).collect(Collectors.toList());
        int max = Collections.max(locations);

        return cars.stream().filter(car -> car.getLocation() == max).collect(Collectors.toList());
    }
}
