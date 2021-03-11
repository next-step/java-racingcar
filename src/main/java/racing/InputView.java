package racing;

import java.util.Scanner;

public class InputView extends View<Integer, String> {
    final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Integer show(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}
