package step2.model;

import step2.eumSet.StatusNumber;

public class Car {

    private int carPosition;
    private int carPositionStatusNumber;
    private String carName;

    public Car(String carName){
        this.carName = carName;
        this.carPosition = StatusNumber.STOP.getValue();
    }

    public void carPositionUpdate(int carPositionStatusNumber) {
        this.carPositionStatusNumber = carPositionStatusNumber;

        int carPostionUpdateNumber = carPositionUpdateValue();
        if(carPosition == StatusNumber.STOP.getValue()){
            carPostionUpdateNumber = StatusNumber.EXCUTE.getValue();
        }
        this.carPosition += carPostionUpdateNumber;
    }

    public int lastCarPosition(){
        return this.carPosition;
    }

    public String name(){
        return this. carName;
    }

    private int carPositionUpdateValue() {
        if (carPositionStatusNumber < StatusNumber.EXCUTE_STANDARD.getValue()) {
            return StatusNumber.STOP.getValue();
        }
        return StatusNumber.EXCUTE.getValue();
    }

}
