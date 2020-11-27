package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Scoreboard {
    private List<Car> cars;
    private int move;
    private List<String> history;

    public void setMove(int move){
        this.move = move;
    }

    public List<Car> getCars() {
        return cars;
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
    
    public Scoreboard(List<Car> cars){
        this.cars = cars;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Scoreboard scoreboard = (Scoreboard) obj;
        return move == scoreboard.getMove() &&
            history == scoreboard.getHistory() &&
                Objects.equals(cars, scoreboard.getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, move, history);
    }

}
