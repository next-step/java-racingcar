package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int carNumber;
    private List<Car> carsPosition;

    public RacingGame(int carNumber) {
        this.carNumber = carNumber;
        carsPosition = new ArrayList <>();
        while (carNumber > 0) {
            carsPosition.add(new Car());
            carNumber--;
        }
    }

    public List<Car> move() {
        RacingPosition racingPosition = new RacingPosition();
        carsPosition.forEach((car) -> {
            int randomPostion = racingPosition.carPositionSatatus();
            int positionUpdate = racingPosition.carPositionUpdateValue(randomPostion);
            car.setUpdatePosition(positionUpdate);
        });
        return carsPosition;
    }

}