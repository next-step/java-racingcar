package step4.controller;

import step4.model.CarGame;
import step4.model.Message;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView input = new InputView();
        List<String> carList = input.askName(Message.ASK_CAR_NAME);
        int tryCnt = input.askTryCnt(Message.ASK_TRY_CNT);
//
//        System.out.println("자동차 대수 :" + carCnt);
//        System.out.println("시도 횟수 :" + tryCnt);
//        System.out.println();
//
//        CarGame user = new CarGame();
//        List<String> results = user.playGame(carCnt, tryCnt);
//
//        ResultView result = new ResultView();
//        result.showResult(results, carCnt);

    }
}
