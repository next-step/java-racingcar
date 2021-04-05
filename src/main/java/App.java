import step3.InputView;
import step3.Racing;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();

        inputView.carNumberInput();
        int carNumber = scanner.nextInt();

        inputView.repeatNumberInput();
        int repeatNumber = scanner.nextInt();

        Racing racing = new Racing(carNumber, repeatNumber);
        racing.racing();
    }
}
