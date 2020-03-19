package racingcar;

import static racingcar.InputType.CAR;
import static racingcar.InputType.TRY;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RandomNumGenerator rng = new RandomNumGenerator();

        Question question_car = new Question(inputView, CAR);
        question_car.generate();

        Question question_try = new Question(inputView, TRY);
        question_try.generate();

        Cars cars = new Cars(inputView);
        System.out.println("실행결과");
        cars.moveTryCount(inputView, rng);
    }
}
