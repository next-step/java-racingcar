package racingCar;

import java.util.ArrayList;
import java.util.List;

import static racingCar.RacingCarUtil.createRandomValue;
import static racingCar.RacingCarUtil.splitList;

public class RacingGame {

  private List<Car> carList = new ArrayList<Car>();

    public RacingGame(String names){
        for(String name : splitList(names)) {
            carList.add(new Car(name));
        }
    }

    public GameResult move(){
        for(int carNum=0; carNum< carList.size(); carNum++){
            carList.get(carNum).move(createRandomValue());
        }
        return new GameResult(carList);
    }





}
