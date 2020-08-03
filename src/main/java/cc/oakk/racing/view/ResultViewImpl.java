package cc.oakk.racing.view;

import cc.oakk.racing.Car;
import cc.oakk.racing.printer.Printable;
import cc.oakk.racing.printer.Printer;
import cc.oakk.racing.printer.StandardPrinter;
import cc.oakk.racing.printer.StringPrinter;

public class ResultViewImpl implements ResultView {
    private final StringPrinter<Car> carPrinter;
    private final Printer<String> stringPrinter;

    public ResultViewImpl(StringPrinter<Car> carPrinter) {
        this.carPrinter = carPrinter;
        this.stringPrinter = new StandardPrinter();
    }

    public ResultViewImpl(StringPrinter<Car> carPrinter, Printer<String> stringPrinter) {
        this.carPrinter = carPrinter;
        this.stringPrinter = stringPrinter;
    }

    @Override
    public void printResultHeader() {
        stringPrinter.print("\n실행결과\n");
    }

    @Override
    public void printCar(Printable<Car> car) {
        car.print(carPrinter);
        stringPrinter.print("\n");
    }
}
