package racing.view;

import racing.Car;

import java.util.List;

public class ResultView {

    public void printPositions(List<Car> cars) {
        for (Car car : cars) {
            printPosition(car);
        }
        printLineBreak();
    }

    private void printPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int p = 0 ; p < car.getPosition() ; p++) {
            System.out.print("-");
        }
        printLineBreak();
    }

    private void printLineBreak() {
        System.out.println();
    }

}
