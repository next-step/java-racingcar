package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(List<Integer> moveCntList){
        for (int i=0; i<cars.size(); i++) {
            Car car = cars.get(i);
            car.move(moveCntList.get(i));
        }
    }

    public List<String> getCurMoveStateExps(){
        List<String> curMoveStateBars = new ArrayList<>();
        for(Car car: cars){
            curMoveStateBars.add(car.getCurMoveStateExp());
        }
        return curMoveStateBars;
    }

    public boolean checkPositions(List<Integer> positionList){
        for(int i=0; i<cars.size(); i++){
            Car car = cars.get(i);
            if(!car.checkPosition(positionList.get(i))){
                return false;
            }
        }
        return true;
    }

}
