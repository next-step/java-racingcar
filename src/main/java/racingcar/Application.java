package racingcar;


import racingcar.common.UserInput;
import racingcar.domain.Helper;
import racingcar.domain.Judgement;
import racingcar.domain.Racing;

public class Application {

    public static void main(String[] args){
        Racing racing = Racing.of();
        UserInput userInput = new UserInput();
        Judgement judgement = new Judgement();
        new Helper().runner(userInput.getSplitUserInput(), racing);
        for (int time = 0; time < userInput.getRacingTryCounter(); time++) {
            racing.drive();
            judgement.carsStatement(racing.getCars());
        }
        judgement.judge(racing.getCars());
    }
}
