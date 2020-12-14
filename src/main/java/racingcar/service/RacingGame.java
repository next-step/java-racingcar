package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.domain.Scoreboard;

public class RacingGame {

    private Racing racing;

    public RacingGame(Racing racing){
        this.racing = racing;
    }

    public Scoreboard setInRacingByName(String[] racer, int move){
        Scoreboard result = racing.moveCar(placetForRacingByName(racer, move));
        return result;
    }

    public Scoreboard placetForRacingByName(String[] racer, int move){
        List<Car> carList = new ArrayList<>(); 
        for(String carName : racer){
            Car car = new Car(carName);
            carList.add(car);
        }
        Scoreboard board = new Scoreboard(new RacingCar(carList));
        board.setMove(move);
        return board;
    }

}
