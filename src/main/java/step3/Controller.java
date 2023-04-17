package step3;

import step3.printer.Printer;
import step3.printer.PrinterImpl;

public class Controller {


    public void main(){
        Input input = new Input();

        int raceCount = input.inputRaceCount();
        int carCount = input.inputCarCount();

        Printer printer = new PrinterImpl();
        Race race = Race.from(raceCount, carCount);

        race.race();
        printer.print(race);
    }
}
