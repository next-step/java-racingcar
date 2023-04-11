package racing;

import java.util.List;
import java.util.Random;

public class ResultView {

    private static final Random RANDOM = new Random();

    public static void resultCars(List<Car> carList){

        for (Car car : carList) {
            car.move(randomNumber());
            car.printLocation();
        }
    }

    private static int randomNumber(){
        return RANDOM.nextInt(10);
    }

}
