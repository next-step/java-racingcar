package racingCar;

import java.util.ArrayList;
import java.util.List;

public class NamedCars {
    private static final String SPLIT_DELIMETER = ",";

    private List<Car> carList;

    public NamedCars(String carNames){
        Car car;
        carList = new ArrayList<>();
        String[] carNameArray = splitCarNames(carNames);

        for(int i=0; i<carNameArray.length; i++) {
            car = new Car(carNameArray[i]);
            this.carList.add(car);
        }
    }

    public NamedCars(List<Car> carList){
        this.carList = carList;
    }

    private String[] splitCarNames(String carNames){
        return carNames.split(SPLIT_DELIMETER);
    }

    public List<Car> getCarList(){
        return carList;
    }

    public int forwardCountOf(int index){
        return carList.get(index).getForwardCount();
    }

    public String carNameOf(int index) {
        return carList.get(index).getCarName();
    }

    public int getMaxForward(){
        int maxForward = 0;
        for(Car car : carList){
            if(car.getForwardCount() >= maxForward) maxForward = car.getForwardCount();
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
}
