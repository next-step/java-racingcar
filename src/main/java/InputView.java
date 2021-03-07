import java.util.Scanner;

public class InputView {
    public String inputIntArgument(String description) {
        System.out.println(description);
        return new Scanner(System.in).nextLine();
    }
}
