package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> moveAll(){
        List<Integer> currentPositionList = new ArrayList<>();
        for (int i=0; i<cars.size(); i++) {
            Car car = cars.get(i);
            currentPositionList.add(car.move());
        }
        return currentPositionList;
    }


    public List<CurPositionResult> getCurPositionResult(){
        List<CurPositionResult> curPositionResults = new ArrayList<>();
        for (Car car: cars) {
            curPositionResults.add(CurPositionResult.of(car));
        }
        return curPositionResults;
    }


    public List<String> getWinners(){
        List<String> res = new ArrayList<>();
        int maxPos = getMaxPosition();

        for(Car car: cars){
            int position = car.getCurPosition();
            if(maxPos == position){
                res.add(car.getName());
            }
        }

        return res;
    }

    public int getMaxPosition(){
        int maxPos = 0;
        for(Car car: cars){
            int position = car.getCurPosition();
            if(maxPos < position){
                maxPos = position;
            }
        }
        return maxPos;
    }


}
