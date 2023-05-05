package step3;

import step3.printer.Printer;

public class Output {

    private final Printer printer;

    public Output(Printer printer) {
        this.printer = printer;
    }

    public void print(Race race){
        printer.print(race);
    }
}
