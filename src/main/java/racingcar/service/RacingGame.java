package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Scoreboard;

public class RacingGame {

    private Racing racing;

    public RacingGame(Racing racing){
        this.racing = racing;
    }

    public List<String> setInRacingByName(List<String> input){
        placetForRacingByName(input);
        System.out.println("실행 결과");
        List<String> result = racing.moveCar(placetForRacingByName(input));
        return result;
    }

    public Scoreboard placetForRacingByName(List<String> input){
        List<Car> carList = new ArrayList<>();
        String[] getName = input.get(0).split(","); 
        for(String carName : getName){
            Car car = new Car(carName);
            carList.add(car);
        }
        Scoreboard board = new Scoreboard(carList);
        board.setMove(Integer.valueOf(input.get(1)));
        return board;
    }

}