package step3.racingCar;

public class RacingGame {
    public static void main(String[] args) {


        Game step3Game = GameFactory.game(new String[]{Game.HOW_MANY_CARS, Game.HOW_MANY_TRYS});
        Game step4Game = GameFactory.game(new String[]{Game.INPUT_CAR_NAMES, Game.HOW_MANY_TRYS});
        step4Game.play();
    }
}
