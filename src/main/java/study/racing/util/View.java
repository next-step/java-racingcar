package study.racing.util;

import java.util.Scanner;

public class View {
    public static final OutputView outputView = new OutputView();
    public static final InputView inputView = new InputView();

    public static class OutputView {
        public void println(String message) {
            System.out.println(message);
        }

        public void printRepeatChar() {
            this.printRepeatChar(' ', 0);
        }

        public void printRepeatChar(char c, int count) {
            this.printRepeatChar("", c, count);
        }

        public void printRepeatChar(String prefix, char c, int count) {
            StringBuilder sb = new StringBuilder().append(prefix);

            for (int i = 0; i < count; i++) {
                sb.append(c);
            }

            System.out.println(sb.toString());
        }
    }

    public static class InputView {
        private static final Scanner scanner = new Scanner(System.in);

        public static int inputInt() {
            return scanner.nextInt();
        }

        public static String inputString() {
            return scanner.nextLine();
        }
    }
}
