package racingcar;

import java.util.Arrays;
import java.util.Scanner;

class InputView {

    private Scanner scanner;

    private String substringName(String name) {
        int beginIndex = 0;
        int endIndex = 5;
        if (name.length() > endIndex) {
            name = name.substring(beginIndex, endIndex);
        }
        return name;
    }

    String[] nextStrings(String message) {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        System.out.println(message);
        String line = scanner.nextLine();
        String delimiter = ",";
        String[] strings = line.split(delimiter);
        return Arrays.stream(strings)
                .map(this::substringName)
                .toArray(String[]::new);
    }

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
