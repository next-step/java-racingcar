package step2;

import java.util.Random;

public class Car {

    private int CAR_POSISION;
    private static final int EXCUTE_STANDARD_NUMBER = 4;
    private static final int GENERATOR_RANGE = 10;
    private static final int EXCUTE_NUMBER = 1;
    private static final int STOP_NUMBER = 0;

    public Car(){
        this.CAR_POSISION = STOP_NUMBER;
    }

    void carPositionUpdate() {
        int carPostionUpdateNumber = EXCUTE_NUMBER;
        if(CAR_POSISION != 0){
            carPostionUpdateNumber = carPositionUpdateValue(carPositionStatus());
        }
        this.CAR_POSISION += carPostionUpdateNumber;
    }

    int carPositionUpdateValue(int carPositionStatusNumber) {
        if (carPositionStatusNumber < EXCUTE_STANDARD_NUMBER) {
            return STOP_NUMBER;
        }
        return EXCUTE_NUMBER;
    }

    int carPositionStatus(){
        Random generator = new Random();
        return generator.nextInt(GENERATOR_RANGE);
    }

    int lastCarPosition(){
        return this.CAR_POSISION;
    }

}
