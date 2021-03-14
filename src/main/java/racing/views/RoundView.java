package racing.views;

import racing.models.Car;
import racing.models.Round;

public class RoundView extends View<Void, Round> {
    @Override
    public Void show(Round round) {
        for (Car car : round.getCars()) {
            showCar(car);
        }

        return null;
    }

    private void showCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
