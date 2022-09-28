package study.racing.step3;

import java.util.Scanner;

public class View {
    public static final OutputView outputView = new OutputView();
    public static final InputView inputView = new InputView();

    public static class OutputView {
        public void printRepeatChar(char c, int count) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < count; i++) {
                sb.append(c);
            }

            System.out.println(sb.toString());
        }

        public void printRepeatChar() {
            this.printRepeatChar(' ', 0);
        }
    }
    public static class InputView {
        private static final Scanner scanner = new Scanner(System.in);

        public static int input(String message) {
            System.out.println(message);
            return scanner.nextInt();
        }
    }
}
