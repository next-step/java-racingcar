package RacingCar.Controller;

import RacingCar.Model.Racing;
import RacingCar.View.Input.Input;
import RacingCar.View.Output.Output;

public class RacingCar {
    static Input input = new Input();
    static Output output = new Output();

    public static void start() {
        Racing racing = new Racing();
        String[] carNames = input.splitCarName(",");
        int count = input.InputTryCount();

        racing.makeCar(carNames);
        output.printOutput();

        for (int i = 0; i < count; i++) {
            racing.roundStart();
            output.printCurLoaction(racing.getCars());
        }

        output.printWinner(racing.getWinner());

    }
}
