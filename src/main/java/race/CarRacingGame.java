package race;

import java.util.ArrayList;
import java.util.List;
import race.domain.Car;
import race.util.RandomNumberUtil;
import race.view.InputView;

public class CarRacingGame {
    public static void main(String[] args) {
        int numberOfCars = InputView.inputNumberOfCars();
        int numberOfTry = InputView.inputNumberOfTry();

        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }

        for(int i = 0; i < numberOfTry; i++) {
            for(Car car : carList){
                car.move(RandomNumberUtil.getRandomNumber());
            }
        }
    }
}
