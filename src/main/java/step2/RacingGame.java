package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int carNumber;
    private List<CarDto> carsPosition;

    public void carPositionsInit(int carNumber) {
        this.carNumber = carNumber;
        carsPosition = new ArrayList <>();
        while (carNumber > 0) {
            carsPosition.add(new CarDto());
            carNumber--;
        }
    }

    public List<CarDto> move() {
        int randomPostion;
        CarDto carDto;
        for (int i = 0; i < carNumber; i++) {
            randomPostion = carPositionSatatus();
            carDto = carsPosition.get(i);
            carDto.setUpdatePosition(carPositionUpdateValue(randomPostion));
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