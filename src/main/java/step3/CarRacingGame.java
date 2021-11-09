package step3;

import java.io.IOException;

public class CarRacingGame {

    public void start() throws IOException {
        GameOutput.println("자동차는 몇 대인가요?\n");
    }

    public static void main(String[] args) throws IOException {
        CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.start();
    }
}
