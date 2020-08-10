package racingcar;

import java.util.Scanner;

class InputView {

    private Scanner scanner;

    int nextInt(String message) {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        System.out.println(message);
        return scanner.nextInt();
    }

    void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}
