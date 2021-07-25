package step4.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList;
    private MoveStrategy movement;

    public Cars(MoveStrategy movement) {
        this.movement = movement;
    }

    public void makeCars(int carCount) {
        carList = new ArrayList<Car>();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public void makeCars(String[] cars) {
        carList = new ArrayList<Car>();

        for(String name : cars){
            carList.add(new Car(name));
        }
    }

    public List<Car> getCarList() {
        stateCheck();
        return this.carList;
    }

    public void moveCars() {
        stateCheck();
        movement.move(this);
    }

    public void stateCheck(){
        if(carList == null || carList.size() == 0){
            throw new IllegalStateException("자동차를 먼저 생성해 주세요.");
        }
    }
}
