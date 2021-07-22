package step3.model;

import step3.RacingApp;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final int RANDOM_BOUND = 10;
    private List<Car> cars;

    public void makeCars(int carCount) {
        cars = new ArrayList<Car>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        stateCheck();
        return this.cars;
    }

    public void moveCars() {
        stateCheck();
        cars.stream().forEach(car -> car.move(RandomFactory.getRandomInt(RANDOM_BOUND)));
    }

    public void stateCheck(){
        if(cars == null || cars.size() == 0){
            throw new IllegalStateException("자동차를 먼저 생성해 주세요.");
        }
    }

    public void firstMovement(){
        cars.stream().forEach(car -> car.move(RacingApp.MOVE_BOUNDARY));
    }

}
