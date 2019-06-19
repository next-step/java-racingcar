package step2;

public class Car {

    private int carPosition;
    private int carPositionStatusNumber;
    private String carName;
    private static final int EXCUTE_STANDARD_NUMBER = 4;
    private static final int EXCUTE_NUMBER = 1;
    private static final int STOP_NUMBER = 0;

    public Car(String carName){
        this.carName = carName;
        this.carPosition = STOP_NUMBER;
    }

    void carPositionUpdate(int carPositionStatusNumber) {
        this.carPositionStatusNumber = carPositionStatusNumber;

        int carPostionUpdateNumber = carPositionUpdateValue();
        if(carPosition == STOP_NUMBER){
            carPostionUpdateNumber = EXCUTE_NUMBER;
        }
        this.carPosition += carPostionUpdateNumber;
    }

    int lastCarPosition(){
        return this.carPosition;
    }

    private int carPositionUpdateValue() {
        if (carPositionStatusNumber < EXCUTE_STANDARD_NUMBER) {
            return STOP_NUMBER;
        }
        return EXCUTE_NUMBER;
    }

}
