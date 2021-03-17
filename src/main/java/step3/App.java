package step3;

import step3.domain.Cars;
import step3.service.GameRule;
import step3.service.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

public class App {
    public static void main(String[] args) {
        // 입력받기
        InputView.inputValues();

        // 레이스 준비
        RacingGame race = new RacingGame(InputView.howManyCars(), InputView.getAttemps(), new GameRule());

        // 자동차 준비
        Cars cars = race.initCars();

        // 레이스 시작
        race.doRace(cars);

        // 결과 출력
        ResultView.printRaceResult(race, cars);
    }
}
