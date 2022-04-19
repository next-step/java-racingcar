package racing.view;

import racing.domain.Car;

import java.util.List;

public class ResultView {

    public void printCarsPosition(List<Car> cars) {
        int index = 1;
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int distance = 0; distance < car.getDistance(); distance++) {
                System.out.print("-");
            }
            index++;
            System.out.println();
        }

        System.out.println();
    }

}
