package racing;

import racing.domain.Car;
import racing.domain.RacingCarRequest;
import racing.service.RacingCarMake;
import racing.service.RacingCarRank;
import racing.service.RacingCarView;

import java.util.List;

public class RacingCar {

    public static void main(String[] args) {

        doRacing(RacingCarView.getRacingCarRequest());

    }

    private static void doRacing(RacingCarRequest racingCarRequest) {

        try {
            String[] names = RacingCarMake.parseCarNames(racingCarRequest.getNames());

            List<Car> cars = RacingCarMake.getCars(names);

            RacingCarMake.moveCars(cars, racingCarRequest.getMoveCnt());

            RacingCarView.viewRacingCar(cars, racingCarRequest.getMoveCnt());

            RacingCarRank.sortCars(cars);

            List<Car> winners = RacingCarRank.rankCars(cars);

            RacingCarView.viewRacingCarWinners(winners);

        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }


}
