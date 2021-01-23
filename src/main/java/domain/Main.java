package domain;

import view.InputView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 입력 : 차 이름, 레이싱 이동 횟수
        String carNames = InputView.inputCarsName();
        int stages = InputView.inputStages();

        // 레이싱 게임 진행
        ArrayList<Car> carsList = Car.asCarsList(carNames);
        Racing racing = new Racing(carsList, stages);
        racing.start(); //TODO : 경기 중 상황 print하는 역할을 오롯 ResultView로 이전하는 리펙토링

        // 진행 결과 output이
        // TODO : 경기 종료 시 우승자 print하는 역할을 오롯이 ResultView로 이전하는 리펙토링
    }
}