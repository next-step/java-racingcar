package racingcar;


import racingcar.view.RacingCarUserInput;
import racingcar.model.domain.Helper;
import racingcar.view.RacingCarUserOutput;
import racingcar.model.domain.Racing;

public class Application {

    private static final int NUMBER_ZERO = 0;

    public static void main(String[] args) {
        Racing racing = Racing.get();
        RacingCarUserInput userInput = new RacingCarUserInput();
        RacingCarUserOutput judgement = new RacingCarUserOutput();
        userInput.userInputRun();
        new Helper().run(userInput.getSplitUserInput(), racing);
        for (int time = NUMBER_ZERO; time < userInput.getRacingTryCounter(); time++) {
            racing.drive();
            judgement.carsStatement(racing.getCars());
        }
        judgement.judge(racing.getCars());
    }
}

