package mission1.racing.view;

import java.util.Scanner;

public class RacingGameInputView {
    private Scanner scanner = new Scanner(System.in);

    public String inputView(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

}
