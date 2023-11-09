package racingCar;

public class Car {
    private String carName;

    public Car(String carName){
        checkCarName(carName);
        this.carName = carName;
    }

    public String getCarName(){
        return carName;
    }

    private void checkCarName(String carName){
        if(carName.length()>5){
            throw new RuntimeException();
        }
    }
}
