import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView () {
        this.scanner = new Scanner(System.in);
    }

    public String inputArgument(String description) {
        System.out.println(description);
        return scanner.nextLine();
    }
}
