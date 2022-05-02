package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> moveAll(){
        List<Integer> curLocList = new ArrayList<>();
        for (int i=0; i<cars.size(); i++) {
            Car car = cars.get(i);
            curLocList.add(car.move());
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

    public List<String> getNames(){
        List<String> nameList = new ArrayList<>();
        for(Car car: cars){
            nameList.add(car.getName());
        }
        return nameList;
    }

    public List<String> getWinners(){
        List<String> res = new ArrayList<>();
        int maxPos = 0;
        for(Car car: cars){
            int position = car.getCurPosition();
            if(maxPos < position){
                maxPos = position;
            }
        }

        for(Car car: cars){
            int position = car.getCurPosition();
            if(maxPos == position){
                res.add(car.getName());
            }
        }

        return res;
    }



}
