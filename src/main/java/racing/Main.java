package racing;

import racing.domain.Racing;
import racing.view.InputView;
import racing.view.ResultView;
import racing.domain.Winner;

import java.util.List;
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

        List<String> users = inputView.getUsers(scanner);
        Integer attempts = inputView.getAttempts(scanner);

        Racing racing = new Racing(users, attempts);
        Winner winner = racing.play(random);

        resultView.print(winner);
    }
}
