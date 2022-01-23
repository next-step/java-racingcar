package racingcar;


import racingcar.common.UserInput;
import racingcar.domain.Cars;
import racingcar.domain.Judgement;
import racingcar.domain.Racing;
import racingcar.domain.movable.ForwardStrategy;

public class Application {

    private static final int START_FROM_ZERO = 0;

    public static void main(String[] args) {
        Racing racing = Racing.instance();
        UserInput userInput = UserInput.instance();
        Judgement judgement = Judgement.instance();
        Cars cars = Cars.of(userInput.getSplitUserInput(), new ForwardStrategy());
        for (int time = START_FROM_ZERO; time < userInput.getRacingTime(); time++) {
            racing.drive(cars.getCars());
            judgement.carsStatement(cars.getCars());
        }
        System.out.println(judgement.judge(cars.getCars()));
    }

}
