package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int carNumber;
    private List<Car> carsPosition;

    public void carPositionsInit(int carNumber) {
        this.carNumber = carNumber;
        carsPosition = new ArrayList <>();
        while (carNumber > 0) {
            carsPosition.add(new Car());
            carNumber--;
        }
    }

    public List<Car> move() {
        int randomPostion;
        Car car;
        for (int i = 0; i < carNumber; i++) {
            randomPostion = carPositionSatatus();
            car = carsPosition.get(i);
            car.setUpdatePosition(carPositionUpdateValue(randomPostion));
        }
        return carsPosition;
    }

    private int carPositionSatatus(){
        Random generator = new Random();
        return generator.nextInt(10);
    }

    public int carPositionUpdateValue(int randomNumber) {
        if (randomNumber < 4) {
            return 0;
        }
        return 1;
    }
}