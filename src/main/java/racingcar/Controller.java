package racingcar;

import racingcar.input.Input;
import racingcar.input.request.CarRequest;
import racingcar.numbergenerator.RandomNumberGenerator;
import racingcar.printer.Printer;
import racingcar.printer.PrinterImpl;

public class Controller {

    public static void main(String[] args) {
        new Controller().main();
    }


    public void main(){
        Input input = new Input();

        int raceCount = input.inputRaceCount();
        CarRequest carRequest = input.inputCar();

        Printer printer = new PrinterImpl();
        Race race = Race.from(raceCount, carRequest.toResource(), new RandomNumberGenerator());

        race.race();
        printer.print(race);
    }
}
