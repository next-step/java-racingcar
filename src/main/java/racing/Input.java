package racing;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    Input() {
        this.scanner = new Scanner(System.in);
    }

    public int askIntInput(String inputAsk) {
        System.out.println(inputAsk);
        return scanner.nextInt();
    }

    public String askStringInput(String inputAsk) {
        System.out.println(inputAsk);
        return scanner.nextLine();
    }

    public void close() {
        this.scanner.close();
    }
}
