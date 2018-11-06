package racinggame.view.console;

import racinggame.domain.car.Car;

import java.util.List;

public class ResultView {

    public void print(List<Car> cars) {
        for(int i =0; i < cars.size(); i++){
            printCarName(cars.get(i));
            printCar(cars.get(i));
        }
        System.out.println();
    }

    private void printCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    private void printCar(Car car) {
        for(int i =0; i < car.getLocation(); i++){
            System.out.print("-");
        }
        System.out.println();
    }


}
