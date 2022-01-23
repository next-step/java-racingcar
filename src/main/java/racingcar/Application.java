package racingcar;


import racingcar.common.UserInput;
import racingcar.domain.Helper;
import racingcar.domain.Judgement;
import racingcar.domain.Racing;

public class Application {

    private static final int START_FROM_ZERO = 0;

    public static void main(String[] args) {
        Racing racing = Racing.instance();
        UserInput userInput = UserInput.instance();
        Judgement judgement = Judgement.instance();
        new Helper().runner(userInput.getSplitUserInput(), racing);
        for (int time = START_FROM_ZERO; time < userInput.getRacingTime(); time++) {
            racing.drive();
            judgement.carsStatement(racing.getCars());
        }
        System.out.println(judgement.judge(racing.getCars()));
    }

}
