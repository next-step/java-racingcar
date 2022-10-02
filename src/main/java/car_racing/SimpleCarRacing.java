package car_racing;

public class SimpleCarRacing {

    public static void main(String[] args) {
        RacingCondition racingCondition = new ConsoleInput().getInputs();

        Cars cars = new Cars(racingCondition.carCount());

        Game game = new Game(racingCondition.attemptCount(), cars, new ConsoleGameDashBoard());

        game.play();
    }
}
