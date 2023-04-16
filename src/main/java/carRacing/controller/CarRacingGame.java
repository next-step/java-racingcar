package carRacing.controller;

import carRacing.domain.Car;
import carRacing.domain.CarCompany;
import carRacing.view.InputView;
import carRacing.view.ResultView;

import java.util.List;

import static carRacing.domain.Race.moveCars;

public class CarRacingGame {
    public static void main(String[] args) {
        //자동차 대수 및 이동 횟수 입력
        InputView inputView = new InputView();
        int carNum = inputView.inputCarNum();
        int moveNum = inputView.inputMoveNum();

        //입력 대수만큼 자동차 객체 생성
        CarCompany carCompany = new CarCompany();
        List<Car> cars = carCompany.createCar(carNum);

        for (int i = 0; i < moveNum; i++) {
            //자동차 이동
            cars = moveCars(cars);
        }
    }
}
