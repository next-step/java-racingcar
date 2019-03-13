package car.entity;

import car.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    //TEST CASE 때문에 private 에서 public 으로 변환해놓음.
    public List<Car> racingCars;
    public GameResult gameResult;

    public RacingGame(int carCount) {
        gameResult = GameResult.initGameResult();
        racingCars = createRacingCars(carCount);
    }

    private List<Car> createRacingCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        int i = 0;

        while (i < carCount) {
            cars.add(Car.getCarInstance());
            i ++;
        }

        return cars;
    }

    public GameResult playingGame(int tryCount) {
        int i = 0;

        while (i < tryCount) {
            move();

            //TODO :: racing 의 현재 상태를 List<Car> racingCars에서 저장하면서 사용하려고하니
            //동일한 array 객체가 list에 add 되면서 최종현상만 출력되고있습니다.
            //어느단계에서 분리하여 끊어줘야할 지 잘 이해가 가지 않아서 올려요.. 조언부탁드립니다.
            RacingRound racingRound = RacingRound.getRacingRoundInstance(racingCars);
            gameResult.pushGameResult(racingRound);

            i ++;
        }
        return gameResult;
    }

    private void move() {
        racingCars.stream().forEach(car -> {
            car.move(RandomNumber.getNumber());
        });
    }
}
