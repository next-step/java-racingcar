package racing;

import racing.domain.Car;
import racing.service.RacingCarGame;
import racing.service.RacingCarRank;
import racing.service.RacingCarView;

import java.util.List;

public class RacingCar {

    public static void main(String[] args) {
        doRacing(RacingCarView.getCarNames(), RacingCarView.getRoundCount());
    }

    private static void doRacing(String carNames, int roundCnt) {
        try {
            //입력값 파싱
            String[] names = RacingCarView.parseCarNames(carNames);

            //레이싱
            List<Car> cars = RacingCarGame.startRacing(RacingCarGame.createCars(names), roundCnt);

            //랭킹
            RacingCarView.viewRacingCarWinners(RacingCarRank.rankCars(cars));
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }


}
