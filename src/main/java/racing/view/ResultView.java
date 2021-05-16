package racing.view;

import racing.domain.Car;

import java.util.List;

public class ResultView {


    public void printCars(List<Car> cars) {

        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            int movingRange = car.getMovingRange();
            resultMovingRange(movingRange);
            System.out.println();
        }
    }

    private void resultMovingRange(int movingRange) {
        for (int i = 0; i < movingRange; i++) {
            System.out.print("-");
        }
    }
}
