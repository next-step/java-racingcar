package racingcar;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CarCollection {
    private List<Car> carList;

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

    public List<Integer> getPositionList() {
        List<Integer> positionList = new ArrayList<>();
        for (Car car: this.carList){
            positionList.add(car.getPosition());
        }
        return positionList;
    }

    public int size() {
        return this.carList.size();
    }
}
