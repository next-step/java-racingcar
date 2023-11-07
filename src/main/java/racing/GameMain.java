package racing;

import java.util.List;

public class GameMain {

    public static void main(String[] args) {

        //게임 데이터 입력
        RaceInfo raceInfo = InputView.inputInfo();

        //자동차 생성
        Car car = new Car();
        List<Car> cars = car.generateCar(raceInfo.carData());

        //게임 진행 & 상태 출력
        Racing.goRacing(cars, raceInfo.trialData());
    }
}
