package racinggame.view;

import java.util.List;
import racinggame.domain.Car;

public class ResultView {

    public void printCarsLocation(List<Car> cars){
            for (Car car : cars) {
                System.out.print(car.getCarName() + " : " + "");
                for (int i = 0; i < car.getLocation(); i++) {
                    System.out.print('-');
                }
                System.out.println();
            }
            System.out.println();
        }

}
