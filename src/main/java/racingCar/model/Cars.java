package racingCar.model;

import racingCar.utils.RandomUtil;
import racingCar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;
    private int playCount;

    public Cars(String[] carNames, int playCount) {
        this.cars = makeCars(carNames);
        this.playCount = playCount;
    }

    private List<Car> makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for(String carName: carNames){
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(RandomUtil.getNumber());
            ResultView.printLocation(car);
            System.out.println();
        }
    }

    public void play() {
        for (int i = 0; i < playCount; i++) {
            moveCars();
            System.out.println();
        }
    }

    public int getPlayCount(){
        return playCount;
    }
}
