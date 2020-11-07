package study1.step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    private Cars(List<Car> cars){
        this.cars = cars;
    }

    public static Cars of(int carCnt){
        return new Cars(makeList(carCnt));
    }

    private static List<Car> makeList(int carCnt){
        List<Car> inputList = new ArrayList<>();
        for(int i = 0; i < carCnt; i++){
            inputList.add(new Car(1));
        }
        return inputList;
    }

    public void race(Decision moveDecisionMaker){
        this.cars.forEach(car -> car.move(moveDecisionMaker));
    }

    public List<Car> getCars(){
        return cars;
    }
}
