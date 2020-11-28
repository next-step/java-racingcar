package racingcar.domain;

import java.util.List;

public class Scoreboard {
    private RacingCar cars;
    private int move;
    private List<String> history;

    public void setMove(int move){
        this.move = move;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getMove() {
        return move;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> list){
        this.history = list;
    }
    
    public Scoreboard(RacingCar cars){
        this.cars = cars;
    }

}
