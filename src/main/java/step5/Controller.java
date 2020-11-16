package step5;

import step5.domain.InputValue;
import step5.domain.racing.Racing;
import step5.domain.strategy.Movable;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.Scanner;

/**
 * Created By mand2 on 2020-11-04.
 * 실제 게임 보여주는 판.
 */
public class Controller {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void execute() {

        InputValue inputValue = InputView.askQuestions();

        Racing racing = Racing.of(inputValue, new Movable());
        racing.race();

        ResultView.printResult(racing);

        SCANNER.close();

    }

}
