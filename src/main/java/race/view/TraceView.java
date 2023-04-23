package race.view;

import java.util.List;
import race.domain.Car;
import race.util.Distance;

public class TraceView {


    public void printMovingResult(List<Car> racingCars) {
        for (Car racingCar : racingCars) {
            String distance = Distance.get(racingCar.getMovingDistance());
            System.out.println(racingCar.getName() + " : " + distance);
        }
    }
}
