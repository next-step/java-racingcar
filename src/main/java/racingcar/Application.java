package racingcar;


import racingcar.common.UserInput;
import racingcar.domain.Helper;
import racingcar.domain.Judgement;
import racingcar.domain.Racing;

public class Application {

    private static final int START_FROM_ZERO = 0;

    public static void main(String[] args) {
        Racing racing = Racing.of();
        UserInput userInput = new UserInput();
        Judgement judgement = new Judgement();
        new Helper().runner(userInput.getSplitUserInput(), racing);
        for (int time = START_FROM_ZERO; time < userInput.getRacingTryCounter(); time++) {
            racing.drive();
            judgement.carsStatement(racing.getCars());
        }
        judgement.judge(racing.getCars());
    }

}
