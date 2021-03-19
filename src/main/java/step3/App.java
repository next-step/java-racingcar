package step3;

import step3.controller.RacingGame;
import step3.domain.CarFactory;
import step3.domain.Cars;
import step3.service.GameRule;
import step3.view.InputView;
import step3.view.ResultView;

public class App {
    public static void main(String[] args) {
        // 입력받기
        InputView.inputValues();

        // 자동차 준비
        CarFactory factory = new CarFactory(InputView.getNumberOfCars());
        Cars cars = factory.getCars();

        // 레이스 준비
        RacingGame race = new RacingGame(InputView.getNumberOfCars(), InputView.getAttemps(), new GameRule(), cars);

        // 레이스 시작
        race.doRace();

        // 결과 출력
        ResultView.printRaceResult(race);
    }
}
