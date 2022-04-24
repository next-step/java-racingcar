package carrace.ui;

import carrace.Car;
import carrace.CarRace;

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

    public void printWinners(CarRace carRace) {
        int i = 0;
        for (Car car : carRace.getRaceWinner().getWinners()) {
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
