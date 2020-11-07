package step3;

import step3.service.Racing;
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
        String carNames = InputView.askCarNames();

//        Racing racing = Racing.of(carNum, roundNum);
        Racing racing = Racing.of(carNames, roundNum);
        racing.race();

        ResultView.printResult(racing.getScoreBoard(), racing.getParticipantsNum());

        SCANNER.close();
    }

}
