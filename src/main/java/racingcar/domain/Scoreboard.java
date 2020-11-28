package racingcar.domain;

import java.util.List;

public class Scoreboard {
    private RacingCar racingaCar;
    private int move;
    private List<String> history;

    public void setMove(int move){
        this.move = move;
    }

    public RacingCar getRacingCar() {
        return racingaCar;
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
        this.racingaCar = cars;
    }

}
