package carRacing.controller;

import carRacing.view.InputView;

public class CarRacingGame {
    public static void main(String[] args) {
        //자동차 대수 및 이동 횟수 입력
        InputView inputView = new InputView();
        int carNum = inputView.inputCarNum();
        int moveNum = inputView.inputMoveNum();
    }
}
