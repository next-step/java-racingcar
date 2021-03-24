package step3;

import step3.controller.RacingGame;
import step3.domain.Cars;
import step3.utils.GameRule;
import step3.utils.NumberGenerator;
import step3.utils.RandomUtil;
import step3.view.InputView;
import step3.view.ResultView;

public class App {
    public static void main(String[] args) {
        // 입력받기
        InputView.inputValues();

        // 자동차 준비
        Cars cars = new Cars(InputView.getCarNames());

        // 레이스 준비
        NumberGenerator numberGenerator = new RandomUtil();
        GameRule rule = new GameRule(numberGenerator);
        RacingGame race = new RacingGame(InputView.getNumberOfAttemps(), rule, cars);

        // 레이스 시작
        race.startRace();

        // 챔피언 출력
        ResultView.printChampions(race.getChampion());
    }
}
