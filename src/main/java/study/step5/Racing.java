package study.step5;

import study.step5.domain.Car;
import study.step5.domain.Cars;
import study.step5.domain.RandomMovingStrategy;
import study.step5.view.ResultView;

/**
 * Racing Game Class
 *
 * 자동차 경주 클래스
 *
 */
public class Racing {
    private Cars cars;

    public Racing() {
        cars = new Cars();
    }

    public void ready(String inputCarNameStr) {
        String[] inputCarNames = inputCarNameStr.split(",");
        for(int i=0; i<inputCarNames.length; i++) {
            cars.addCar(new Car(inputCarNames[i]));
        }
    }

    public void play(int totalRound) {
        ResultView.printRacingStart();
        for(int i=0; i<totalRound; i++) {
            ResultView.printRacingRound(i + 1);
            cars.run(new RandomMovingStrategy());
            ResultView.printRacingResult(cars.getCars());
        }
        ResultView.printRacingWinner(cars.findWinners());
    }
}
