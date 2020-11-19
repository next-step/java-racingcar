package racingcar.domain;

import java.util.List;
import java.util.stream.Stream;

public class Scoreboard {
    private List<Car> cars;
    private int move;

    public void setMove(int move){
        this.move = move;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMove() {
        return move;
    }
    
    public Scoreboard(List<Car> cars){
        this.cars = cars;
    }

}