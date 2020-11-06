package study1.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    private Cars(List<Car> carList){
        this.carList = carList;
    }

    public static Cars of(int carCnt){
        return new Cars(makeList(carCnt));
    }

    private static List<Car> makeList(int carCnt){
        List<Car> inputList = new ArrayList<>();
        for(int i = 0; i < carCnt; i++){
            inputList.add(new Car());
        }
        return inputList;
    }

    public void race(Decision moveDecisionMaker){
        this.carList.forEach(car -> car.move(moveDecisionMaker));
    }

    public List<Car> getCarList(){
        return carList;
    }
}
