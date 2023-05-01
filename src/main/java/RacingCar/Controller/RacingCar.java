package RacingCar.Controller;

import RacingCar.Model.Car;
import RacingCar.Model.RacingRound;
import RacingCar.Model.RegisteredCar;
import RacingCar.View.Input.Input;
import RacingCar.View.Output.Output;

import java.util.ArrayList;

public class RacingCar {
    static Input input = new Input();
    static Output output = new Output();

    public static void start() {
        RacingRound racingRound = new RacingRound();
        RegisteredCar registeredCar = new RegisteredCar();
        String[] carNames = input.splitCarName(",");
        int count = input.InputTryCount();

        registeredCar.makeCar(carNames);
        output.printOutput();

        for (int i = 0; i < count; i++) {
            ArrayList<Car> cars = racingRound.roundStart(registeredCar.getRegisteredCar());
            output.printCurLoaction(cars);
        }

        output.printWinner(racingRound.getWinner(registeredCar.getRegisteredCar()));

    }
}
