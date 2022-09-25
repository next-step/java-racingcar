package step3;

public class SimpleCarRacing {

    public static void main(String[] args) {
        RacingCondition racingCondition = RacingCondition.getInput();
        Game game = Game.prepare(racingCondition);
        game.play();
    }
}
