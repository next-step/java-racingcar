package ThirdStep;

import ThirdStep.Enums.Compare;
import ThirdStep.interfaces.MovingCondition;
import ThirdStep.model.Car;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class CarAction {
    private static final String LOCATION_SIGN = "-";

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
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        TextPrinter.println(String.format("%s가 최종 우승했습니다.", winnerNames));
    }

    private List<Car> getWinners(List<Car> cars) {
        AtomicReference<List<Car>> winner = new AtomicReference<>(Collections.singletonList(cars.get(0)));

        cars.forEach(car -> {
            int headLocation = winner.get().get(0).getLocation();
            if (headLocation > car.getLocation()) {
                return;
            }
            if (headLocation == car.getLocation()) {
                winner.get().add(car);
            }
            if (headLocation < car.getLocation()) {
                winner.set(List.of(car));
            }
        });

        return winner.get();
    }
}
