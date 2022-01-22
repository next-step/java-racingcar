package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (int carNum = 0; carNum < carNames.length; carNum++) {
            cars.add(new Car(carNames[carNum]));
        }
    }

    public List<Car> createCarList(String[] carNames) {
        //Car들 모임
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> getCars(){
        return cars;
    }

    public void move(List<Integer> randomNumberList) {
        for (int i=0;i< randomNumberList.size() ; i++) {
            if (randomNumberList.get(i) >= 4) {
                Car car = cars.get(i);
                int location = car.getLocation();
                location++;
                car.updateLocation(location);
            }
        }

    }

}
