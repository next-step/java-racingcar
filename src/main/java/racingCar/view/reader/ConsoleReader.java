package racingCar.view.reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String readLine() {
        return scanner.nextLine().trim();
    }
}
