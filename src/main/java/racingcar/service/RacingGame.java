package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import racingcar.domain.Car;
import racingcar.domain.Scoreboard;

public class RacingGame {

    private Racing racing;

    public RacingGame(Racing racing){
        this.racing = racing;
    }

    public List<String> setInRacingByName(Map<Integer, String[]> map){
        List<String> result = racing.moveCar(placetForRacingByName(map));
        return result;
    }

    public Scoreboard placetForRacingByName(Map<Integer, String[]> input){
        List<Car> carList = new ArrayList<>(); 
        for(String carName : input.get(0)){
            Car car = new Car(carName);
            carList.add(car);
        }
        Scoreboard board = new Scoreboard(carList);
        board.setMove(Integer.valueOf(input.get(1)[0]));
        return board;
    }

}
