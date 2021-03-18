package racing.views;

import racing.domain.Car;
import racing.domain.Round;

public class RoundView extends View<Void, Round> {
    @Override
    public Void show(Round round) {
        for (Car car : round.getCarList()) {
            showCar(car);
        }

        return null;
    }

    private void showCar(Car car) {
        System.out.print(String.format("%-" + Car.MAX_NAME_LENGTH + "s", car.getName()) + " : ");
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
