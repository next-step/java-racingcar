package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> moveAll(List<Integer> moveCntList){
        List<Integer> curLocList = new ArrayList<>();
        for (int i=0; i<cars.size(); i++) {
            Car car = cars.get(i);
            curLocList.add(car.move(moveCntList.get(i)));
        }
        return curLocList;
    }

    public List<String> getCurMoveStateExps(){
        List<String> curMoveStateBars = new ArrayList<>();
        for(Car car: cars){
            curMoveStateBars.add(car.getCurMoveStateExp());
        }
        return curMoveStateBars;
    }


}
