package step3;

public class Application {

    public static void main(String[] args) {
        GameStrategy game = new RacingCarGame(new RacingCarForwardMatcher());

        game.start();
    }

}
