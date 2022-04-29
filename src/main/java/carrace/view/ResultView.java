package carrace.view;

import carrace.domain.Car;
import carrace.domain.CarRace;

import java.util.List;

public class ResultView {
    public void printCarRace(CarRace carRace) {
        for (Car car : carRace.getCars()) {
            printResultOfEachCar(car);
        }
        System.out.println();
    }

    private void printResultOfEachCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        int i = 0;
        for (Car car : winners) {
            printComma(i++);
            System.out.print(car.getName());
        }
        System.out.println("가 우승했습니다.");
    }

    private void printComma(int i) {
        if (i != 0) {
            System.out.print(", ");
        }
    }
}
