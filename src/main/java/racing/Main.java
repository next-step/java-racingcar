package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.Random;
import java.util.Scanner;

/**
 * @author han
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.printAndInput(scanner);

        Racing racing = new Racing(inputView.getCars(), inputView.getAttempts());
        racing.play(random);

        resultView.print(racing);
    }
}