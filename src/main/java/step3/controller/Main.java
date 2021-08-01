package step3.controller;

import step3.model.Message;
import step3.model.CarGame;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView input = new InputView();
        int carCnt = input.ask(Message.ASK_CAR_CNT);
        int tryCnt = input.ask(Message.ASK_TRY_CNT);

        System.out.println("자동차 대수 :" + carCnt);
        System.out.println("시도 횟수 :" + tryCnt);
        System.out.println();

        CarGame user = new CarGame();
        List<String> results = user.playGame(carCnt, tryCnt);

        ResultView result = new ResultView();
        result.showResult(results, carCnt);

    }
}
