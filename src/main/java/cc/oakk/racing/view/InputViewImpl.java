package cc.oakk.racing.view;

import cc.oakk.racing.printer.Printer;
import cc.oakk.racing.printer.StandardPrinter;

import java.util.Scanner;

public class InputViewImpl implements InputView {
    private final Printer<String> stringPrinter;
    private final Scanner scanner;

    public InputViewImpl() {
        this.stringPrinter = new StandardPrinter();
        this.scanner = new Scanner(System.in);
    }

    public InputViewImpl(Printer<String> stringPrinter, Scanner scanner) {
        this.stringPrinter = stringPrinter;
        this.scanner = scanner;
    }

    @Override
    public int readTotalNumberOfCars() {
        stringPrinter.print("자동차 대수는 몇 대 인가요?\n");
        return scanner.nextInt();
    }

    @Override
    public int readTotalRoundCount() {
        stringPrinter.print("시도할 회수는 몇 회 인가요?\n");
        return scanner.nextInt();
    }
}
