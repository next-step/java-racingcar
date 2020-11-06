package study;
import java.util.Scanner;

public class InputView {
    String message;
    int counts;

    public InputView() {
        message = "";
        counts = 0;
    }

    public InputView(String message) {
        this.message = message;
        this.counts = 0;
    }

    public InputView(String message, int counts) {
        this.message = message;
        this.counts = counts;
    }

    public String getMessage() {
        return this.message;
    }

    public int getCounts() {
        return this.counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public void displayMessage() {
        System.out.println(message);
    }

    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        setCounts(scanner.nextInt());
    }
}
