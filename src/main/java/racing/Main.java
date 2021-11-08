package racing;

import java.util.Scanner;

/**
 * @author han
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.printAndInput(scanner);

        Racing racing = new Racing(inputView.getCars(), inputView.getAttempts());
        racing.play();

        resultView.print(racing);
    }
}