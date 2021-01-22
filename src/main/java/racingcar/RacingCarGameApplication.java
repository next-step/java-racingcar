package racingcar;

import java.util.List;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        Input input = new KeyboardInput(System.in);
        List<String> carNames = input.getCarNames();
        int rounds = input.getRounds();
        RacingGame game = new RacingGame(carNames, rounds);
        game.play();
    }
}
