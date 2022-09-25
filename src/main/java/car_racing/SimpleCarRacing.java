package car_racing;

public class SimpleCarRacing {

    public static void main(String[] args) {
        RacingCondition racingCondition = RacingCondition.getInput();
        Cars cars = new Cars(racingCondition.carCount());
        Game game = Game.prepare(racingCondition.attemptCount(), cars);
        game.play();
    }
}
