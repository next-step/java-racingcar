package racingcar;

import java.sql.Array;
import java.util.ArrayList;

public class CarCollection {
    private ArrayList<Car> carList;

    public CarCollection(int number, MoveStrategy moveStrategy) {
        this.carList = new ArrayList<>();
        for(int i=0; i<number; i++) {
            carList.add(new Car(moveStrategy));
        }
    }

    public void tryMove() {
        for (Car car: this.carList){
            car.tryMove();
        }
    }

    public ArrayList<Integer> getPositionList() {
        ArrayList<Integer> positionList = new ArrayList<>();
        for (Car car: this.carList){
            positionList.add(car.getPosition());
        }
        return positionList;
    }

    public int size() {
        return this.carList.size();
    }
}
