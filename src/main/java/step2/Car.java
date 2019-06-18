package step2;

public class Car {

    private int carPosition;
    private static final int EXCUTE_STANDARD_NUMBER = 4;
    private static final int EXCUTE_NUMBER = 1;
    private static final int STOP_NUMBER = 0;

    public Car(){
        this.carPosition = STOP_NUMBER;
    }

    void carPositionUpdate() {
        int carPostionUpdateNumber = EXCUTE_NUMBER;
        if(carPosition != 0){
            int carPositionStatus = Utils.createRandomNumber();
            carPostionUpdateNumber = carPositionUpdateValue(carPositionStatus);
        }
        this.carPosition += carPostionUpdateNumber;
    }

    int carPositionUpdateValue(int carPositionStatusNumber) {
        if (carPositionStatusNumber < EXCUTE_STANDARD_NUMBER) {
            return STOP_NUMBER;
        }
        return EXCUTE_NUMBER;
    }

    int lastCarPosition(){
        return this.carPosition;
    }

}
