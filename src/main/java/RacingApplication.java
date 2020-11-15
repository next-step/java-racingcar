/*
 * 클래스 이름
 * 레이스 어플리케이션
 * 버전 정보
 * 1.0
 * 날짜
 * 2020.11.01
 * 저작권 주의
 */

import model.Race;
import view.InputView;
import view.ResultView;

public class RacingApplication {
    public static void main (String[] args) {
        InputView inputView = new InputView();
        Race race = new Race();

        String inputNames = inputView.inputCarNamesMessage();
        race.createCars(inputNames);

        int tryCount = inputView.inputTryCountMessage();
        ResultView resultView = new ResultView();

        for (int i = 0; i < tryCount; i++) {
            race.go();
            resultView.printCars(race);
        }
    }
}
