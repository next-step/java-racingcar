package view.presenter;

import domain.Car;

public class CarConsoleUIPresenter implements CarUIPresenter {
    @Override
    public void print(Car car) {
        int position = car.getCurrentPosition();

        System.out.print(car.getCarName() + " : ");

        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }

        System.out.print("\n");
    }
}
