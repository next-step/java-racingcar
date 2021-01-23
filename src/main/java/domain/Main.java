package domain;

import view.InputView;
import view.ResultView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 입력 : 차 이름, 레이싱 이동 횟수
        String carNames = InputView.inputCarsName();
        int stages = InputView.inputStages();

        // 레이싱 게임 진행
        ArrayList<Car> carsList = Car.asCarsList(carNames);
        Racing racing = new Racing(carsList, stages);

        while(!racing.isEnd()) {
            racing.moveCars(); // 1회의 레이싱 상태 갱신
            ResultView.printCurrentCarsState(racing.getCarsList());
        }
        // 진행 결과 output
        ResultView.printWinners(racing.getCarsList(), racing.getMaxDistance());
    }
}