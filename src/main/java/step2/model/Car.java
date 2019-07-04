package step2.model;

import step2.eumset.StatusNumber;

import java.util.Objects;

public class Car {

    private int carPosition;
    private String carName;

    public Car(String carName){
        this.carName = carName;
        this.carPosition = StatusNumber.STOP.getValue();
    }

    public void carPositionUpdate(int carPositionStatusNumber) {
        boolean isUpdate = isCarPositionUpdate(carPositionStatusNumber);
        if(isUpdate || carPosition == StatusNumber.STOP.getValue()){
            this.carPosition += StatusNumber.EXCUTE.getValue();
        }
    }

    public int lastCarPosition(){
        return this.carPosition;
    }

    public String name(){
        return this. carName;
    }

    private boolean isCarPositionUpdate(int carPositionStatusNumber) {
        return carPositionStatusNumber >= StatusNumber.EXCUTE_STANDARD.getValue();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carPosition == car.carPosition &&
                Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(carPosition, carName);
    }

}
