package game;

import game.domain.GameInput;
import game.domain.GameOutput;
import game.domain.Validation;

public class GameClient {

    public static void main(String[] args) {
        GameInput input = GameInput.process();
        Validation.checkIfPositiveNumber(input.getGameCount());
        Validation.checkIfPositiveNumber(input.getCarCount());

        int carCount = Integer.parseInt(input.getCarCount());
        int gameCount = Integer.parseInt(input.getGameCount());

        GameOutput.process();
    }
}
