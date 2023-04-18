package carracing.controller;

import carracing.domain.Car;
import carracing.domain.CarCompany;
import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.List;

import static carracing.domain.Race.moveCars;

public class CarRacingGame {
    public static void main(String[] args) {
        //자동차 대수 및 이동 횟수 입력
        InputView inputView = new InputView();
        //자동차 이름 입력
        String carNames = inputView.inputCarName();

        int moveNum = inputView.inputMoveNum();
    }
}
