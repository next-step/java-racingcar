package step3;

public class Game {
    private int numberOfCars;
    private int numberOfTurns;

    public Game() { }

    public Game(int numberOfCars, int numberOfTurns) {
        this.numberOfCars = numberOfCars;
        this.numberOfTurns = numberOfTurns;
    }

    private TURN goOrStop() {
        return TURN.fromInt(LuckyNumberGenerator.getRandomInt());
    }
}
