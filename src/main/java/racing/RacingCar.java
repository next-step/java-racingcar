package racing;

import racing.domain.Car;
import racing.domain.RacingCarRequest;
import racing.service.RacingCarGame;
import racing.service.RacingCarRank;
import racing.service.RacingCarView;

import java.util.List;

public class RacingCar {

    public static void main(String[] args) {
        doRacing(RacingCarView.registerCars());
    }

    private static void doRacing(RacingCarRequest racingCarRequest) {
        try {
            //자동차 이름 파싱
            String[] names = RacingCarView.parseCarNames(racingCarRequest.getNames());

            //자동차 생성
            List<Car> cars = RacingCarGame.createCars(names);

            //레이싱 시작
            RacingCarGame.startRacing(cars, racingCarRequest.getMoveCnt());

            //자동차 순위결정
            List<Car> winners = RacingCarRank.rankCars(cars);

            //자동차 순위 출력
            RacingCarView.viewRacingCarWinners(winners);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }


}
