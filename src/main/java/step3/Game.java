package step3;

public class Game {
    private TURN goOrStop() {
        return TURN.fromInt(LuckyNumberGenerator.getRandomInt());
    }
}
