package racingCar.domain;

import racingCar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String SPLIT_DELIMETER = ",";

    private List<Car> carList;

    public Cars(String carNames){
        Car car;
        carList = new ArrayList<>();
        String[] carNameArray = splitCarNames(carNames);

        for(int i=0; i<carNameArray.length; i++) {
            car = new Car(carNameArray[i]);
            this.carList.add(car);
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
        return carNames.split(SPLIT_DELIMETER);
    }

    public int getMaxForward(){
        int maxForward = 0;
        for(Car car : carList){
            maxForward = car.returnMaxCount(maxForward);
        }

        return maxForward;
    }

    public List<String> returnWinnerCars(){
        List<String> winners = new ArrayList<>();

        for(Car car : carList){
            car.addMaxForwardCar(getMaxForward(), winners);
        }

        return winners;
    }

    public Car findCar(String carName) {
        return carList.stream()
                .filter(car -> carName.equals(car.getCarName()))
                .findAny()
                .orElse(null);
    }
}
