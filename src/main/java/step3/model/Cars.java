package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;
    private MoveStrategy movement;

    public Cars(MoveStrategy movement) {
        this.movement = movement;
    }

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
        movement.move(this);
    }

    public void stateCheck(){
        if(cars == null || cars.size() == 0){
            throw new IllegalStateException("자동차를 먼저 생성해 주세요.");
        }
    }
}
