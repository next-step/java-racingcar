package step3;

import step3.domain.Racing;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.Scanner;

/**
 * Created By mand2 on 2020-11-04.
 * 실제 게임 보여주는 판.
 */
public class Controller {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int carNum = InputView.askCarNumber();
        int roundNum = InputView.askRoundNumber();

        Racing racing = Racing.of(carNum, roundNum);
        startRacing(roundNum, racing);

        SCANNER.close();
    }

    private static void startRacing(int roundNum, Racing racing) {
        System.out.println();
        ResultView.printResultMessage();

        for (int i = 0; i < roundNum; i++) {
            ResultView.printResult(racing.race());
            System.out.println();
        }
    }

}
