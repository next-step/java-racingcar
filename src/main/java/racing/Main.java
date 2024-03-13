package racing;

import racing.enumable.InputAsk;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Input input = new Input();

        game.createAttendedCars(input.askInput(InputAsk.CarNumber));
        game.playGame(input.askInput(InputAsk.Attempts));

        input.close();
    }
}
