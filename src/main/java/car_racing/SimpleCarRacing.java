package car_racing;

public class SimpleCarRacing {

    public static void main(String[] args) {
        RacingCondition racingCondition = new ConsoleInput().getInputs();
        Game game = new Game(racingCondition.attemptCount(), racingCondition.carCount(), new ConsoleGameDashBoard());
        game.play();
    }
}
