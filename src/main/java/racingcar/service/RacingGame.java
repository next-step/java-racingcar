package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Scoreboard;

public class RacingGame {

    public RacingGame(Racing racing){
        this.racing = racing;
    }
    private Racing racing;

    List<Car> carList = new ArrayList<>();
    int move = 0;

    public void setInRacing(List<Integer> input){
        placetForRacing(input);
        System.out.println("실행 결과");
        racing.moveCar(placetForRacing(input));
    }

    public Scoreboard placetForRacing(List<Integer> input){
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < input.get(0); i++){
            Car car = new Car(i);
            carList.add(car);
        }
        Scoreboard board = new Scoreboard(carList);
        board.setMove(input.get(1));
        return board;
    }

}