package racing;

import racing.enumable.InputAsk;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Input input = new Input();

        game.createAttendedCarsWithName(input.askStringInput(InputAsk.CarName));
        game.playGame(input.askIntInput(InputAsk.Attempts));
        input.close();
        Output.showWinner(game.getWinners());
    }
}
