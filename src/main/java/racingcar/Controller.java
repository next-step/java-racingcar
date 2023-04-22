package racingcar;

import racingcar.numbergenerator.RandomNumberGenerator;
import racingcar.printer.Printer;
import racingcar.printer.PrinterImpl;

public class Controller {


    public void main(){
        Input input = new Input();

        int raceCount = input.inputRaceCount();
        int carCount = input.inputCarCount();

        Printer printer = new PrinterImpl();
        Race race = Race.from(raceCount, carCount, new RandomNumberGenerator());

        race.race();
        printer.print(race);
    }
}
