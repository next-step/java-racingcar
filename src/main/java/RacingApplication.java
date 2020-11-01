/*
 * 클래스 이름
 * 레이스 어플리케이션
 * 버전 정보
 * 1.0
 * 날짜
 * 2020.11.01
 * 저작권 주의
 */

import model.Car;
import model.Race;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingApplication {
    public static void main (String[] args) {
        InputView inputView = new InputView();

        inputView.inputMessage();
        Race race = inputView.getRace();

        List<Car> cars;
        int tryCount = race.getTryCount();

        ResultView resultView = new ResultView();

        for (int i = 0; i < tryCount; i++) {
            cars = race.go();
            resultView.printCars(cars);
        }
    }
}
