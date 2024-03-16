package RacingCar.View;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int getIntData(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }
}
