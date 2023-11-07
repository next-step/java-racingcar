package racing;

import java.util.List;

public class GameMain {

    public static void main(String[] args) {

        //게임 데이터 입력
        RaceInfo raceInfo = InputView.inputNameInfo();

        //자동차 생성
        List<Car> cars = new Car().generateNamedCar(raceInfo);

        //게임 진행 & 상태 출력
        Racing.goRacing(cars, raceInfo.trialData());
    }
}
