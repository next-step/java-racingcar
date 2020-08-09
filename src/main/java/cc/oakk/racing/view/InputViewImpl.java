package cc.oakk.racing.view;

import cc.oakk.racing.printer.Printer;
import cc.oakk.racing.printer.StandardPrinter;

import java.util.*;

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
    public List<String> readNameOfCars() {
        stringPrinter.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
        String input =  scanner.next();
        String[] names = input.split(",");
        if (names.length == 0) {
            throw new RuntimeException("Invalid string.");
        }
        return Arrays.asList(names);
    }

    @Override
    public int readTotalRoundCount() {
        stringPrinter.print("시도할 회수는 몇 회 인가요?\n");
        return scanner.nextInt();
    }
}
