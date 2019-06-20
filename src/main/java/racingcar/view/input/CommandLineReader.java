package racingcar.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandLineReader {

    private Scanner scanner = new Scanner(System.in);
    private NumberReader numberReader = new NumberReader();
    private CsvStringReader csvStringReader = new CsvStringReader();

    public Integer getNumber() {
        return numberReader.parseInput(scanner.nextInt());
    }

    public List<String> getCsv() {
        return csvStringReader.parseInput(scanner.next());
    }

    public static class NumberReader {
        private final Integer MAX_NUMBER = 1000;

        public Integer parseInput(Integer num) {
            if (num == null || num < 0 || num > MAX_NUMBER) {
                throw new IllegalArgumentException("Invalid input");
            }
            return num;
        }
    }

    public static class CsvStringReader {
        private static final String DELIMETER = ",";

        public List<String> parseInput(String str) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("Invalid input");
            }
            return Arrays.asList(str.split(DELIMETER));
        }
    }
}
