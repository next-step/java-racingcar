package racingcar.domain;

public class Scoreboard {
    private RacingCar racingaCar;
    private int move;
    private RacingHistory history;

    public void setMove(int move){
        this.move = move;
    }

    public RacingCar getRacingCar() {
        return racingaCar;
    }

    public int getMove() {
        return move;
    }

    public RacingHistory getHistory() {
        return history;
    }

    public void setHistory(RacingHistory history) {
        this.history = history;
    }
    
    public Scoreboard(RacingCar cars){
        this.racingaCar = cars;
        this.history = new RacingHistory();
    }

}
