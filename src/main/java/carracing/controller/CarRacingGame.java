package carracing.controller;

import carracing.domain.Award;
import carracing.domain.Car;
import carracing.domain.CarCompany;
import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.List;

import static carracing.domain.Race.moveCars;

public class CarRacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        //자동차 이름 입력
        String carNames = inputView.inputCarName();

        //자동차 이름 개수만큼 자동차 객체 생성
        CarCompany carCompany = new CarCompany();
        List<Car> cars = carCompany.createCar(carNames);

        //이동 횟수 입력
        int moveNum = inputView.inputMoveNum();

        ResultView resultView = new ResultView();
        //실행결과 텍스트 출력
        resultView.resultStart();

        for (int i = 0; i < moveNum; i++) {
            //자동차 이동
            cars = moveCars(cars);
            //출력
            resultView.outputResult(cars);
        }

        //시상식
        Award award = new Award();
        String winners = award.getWinner(cars);

        //우승자 출력
        resultView.outputWinnersName(winners);
    }
}
