package mission1.racing.view;

import java.util.Scanner;

public class RacingGameInputView {
    private Scanner scanner = new Scanner(System.in);

    public int inputView(String msg) {
        System.out.println(msg);
        return scanner.nextInt();
    }

}
