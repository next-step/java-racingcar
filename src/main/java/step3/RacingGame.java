package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int carNumber;
    private List<CarDto> carsPosition;

    public void carPositionsInit(String carsName) {
        carsPosition = new ArrayList <>();

        String[] carNameArray = carsName.split(",");
        int carsNameCount = carNameArray.length;
        carNumber = carsNameCount;

        for(int i=0; i<carsNameCount; i++){
            carsPosition.add(new CarDto(carNameArray[i]));
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
