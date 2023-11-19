package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String SPLIT_DELIMITER = ",";
    public static final int RANDOM_LIMIT_VALUE = 10;

    private List<Car> carList;

    public Cars(String carNames){
        carList = new ArrayList<>();
        String[] carNameArray = splitCarNames(carNames);

        for(int i=0; i<carNameArray.length; i++) {
            this.carList.add(new Car(carNameArray[i]));
        }
    }

    public Cars(int carCount){
        carList = new ArrayList<>();
        for(int i=0; i<carCount; i++){
            this.carList.add(new Car(0));
        }
    }

    public Cars(List<Car> carList){
        this.carList = carList;
    }

    public List<Car> getCarList(){
        return carList;
    }

    private String[] splitCarNames(String carNames){
        return carNames.split(SPLIT_DELIMITER);
    }

    public List<Car> addCarMoving(){

        for(Car car : carList){
            car.moveCar(RandomNumber.getRandom(RANDOM_LIMIT_VALUE));
        }

        return carList;
    }

    public Car findCar(String carName) {
        return carList.stream()
                .filter(car -> carName.equals(car.getCarName()))
                .findAny()
                .orElse(null);
    }
}
