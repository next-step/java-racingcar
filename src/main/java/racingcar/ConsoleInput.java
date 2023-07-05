package racingcar;

import java.util.Scanner;

public class ConsoleInput implements Input {
    @Override
    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
