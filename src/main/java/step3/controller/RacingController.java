package step3.controller;

import step3.domain.Car;
import step3.domain.Racing;
import step3.util.InputView;
import step3.util.ResultView;
import step3.util.Validator;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingController {

    private static final String SEPARATOR = ",";

    public void startRace() {
        // 입력 받기
        InputView inputView = new InputView(new Scanner(System.in));

        String carNames = inputView.enterCarName();
        int gameCount = inputView.enterGameCount();

        Racing racing = new Racing(new Random());

        // 입력 받은 차 이름 나누기
        String[] names = carNames.split(SEPARATOR);

        // input check
        Validator validator = new Validator();
        validator.checkInput(names, gameCount);

        // 입력 받은 이름으로 Car 객체 생성
        List<Car> cars = racing.initCars(names);

        ResultView resultView = new ResultView();
        resultView.printGameResultHeader();

        // 게임 실행
        for(int i = 0; i < gameCount; i++) {
            racing.startRace(cars);
            resultView.printDistance(cars);
            resultView.printNewLine();
        }

        // 게임 결과 출력
        List<String> winners = racing.getWinner(cars);
        resultView.printGameWinners(winners);
    }

}
