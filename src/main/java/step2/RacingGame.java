package step2;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> carsPosition;

    public RacingGame(int carNumber) {
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