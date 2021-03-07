package racingcar.module;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public List<Car> initCarGame(int tryNum){
        List<Car> carList = new ArrayList<>();
        for(int num = 0 ; num < tryNum ; num++){
            carList.add(new Car(num+1));
        }
        return carList;
    }

}
