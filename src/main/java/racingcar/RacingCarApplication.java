package racingcar;

import racingcar.domain.Cars;
import racingcar.dto.InputView;
import racingcar.dto.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

        Question question = new Question(inputView);
        int carCount = question.generateForCarCount();
        int tryCount = question.generateForTryCount();

        Cars cars = new Cars(carCount);
        OutputView outputView = new OutputView(cars, randomNumGenerator);
        outputView.printCarsAfterTryCountMove(tryCount);
    }
}