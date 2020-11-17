package racingcar;

import java.util.List;

public class Scoreboard {
    private List<Car> cars;
    private int move;

    public void setCars(List<Car> list){
        this.cars = list;
    }

    public void setMove(int move){
        this.move = move;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMove() {
        return move;
    }
    
}