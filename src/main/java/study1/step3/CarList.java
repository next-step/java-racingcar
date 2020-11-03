package study1.step3;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> carList = new ArrayList<>();
    Decision moveDecisionMaker;

    CarList(int carCnt, Decision moveDecisionMaker){
        this.moveDecisionMaker = moveDecisionMaker;
        for (int i = 0; i < carCnt; i ++){
            carList.add(new Car());
        }
    }

    public void race(){
        this.carList.forEach(car -> car.move(moveDecisionMaker));
    }

    public List<Car> getCarList(){
        return carList;
    }
}
