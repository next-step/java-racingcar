package view.presenter;

import domain.Car;

public class CarConsoleUIPresenter implements CarUIPresenter {
    @Override
    public void print(Car car) {
        int position = car.getCurrentPosition();
        StringBuilder output = new StringBuilder();

        output.append(car.getCarName()).append(" : ");
        output.append("-".repeat(position));
        output.append("\n");

        System.out.print(output);
    }
}
