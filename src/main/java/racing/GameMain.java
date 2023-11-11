package racing;

import racing.domain.Car;
import racing.domain.RaceInfo;
import racing.domain.Racing;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class GameMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        Racing racing = new Racing();
        ResultView resultView = new ResultView();

        //게임 데이터 입력
        RaceInfo raceInfo = inputView.inputNameInfo();

        //자동차 생성
        List<Car> cars = racing.generateNamedCar(raceInfo);

        //게임 진행
        racing.goRacing(cars, raceInfo);

        //진행 상태 출력
        resultView.status(cars, raceInfo);

        //우승자 출력
        resultView.raceResult(cars);
    }
}
