package racing;

import java.util.List;
import java.util.ArrayList;

public class RacingGame {
    private static final int SECOND_ROUND_NUM = 2;
    // 운행횟수
    private int time;
    // Car 컬렉션
    private List<Car> cars;
    // 각 라운드 차량 이동정보
    private List<CarRoundResult> carRoundResult;
    // 라운드별 결과
    private List<RacingGameRoundResult> racingGameRoundResult;

    RacingGame(final int time, List<String> carNames) {
        this.time = time;
        this.cars = new ArrayList<Car>();
        this.carRoundResult = new ArrayList<CarRoundResult>();
        this.racingGameRoundResult = new ArrayList<RacingGameRoundResult>();

        for (String carName : carNames) {
            Car car = new Car(carName, 1);
            cars.add(car);
            // 첫번째운행은 무조건이동
            carRoundResult.add(new CarRoundResult(car.getCarName(), car.getMovePosition()));
        }
    }

    // 운행횟수
    public RacingGameResult runRacingGame(GameRule gameRule) {
        // 첫번째라운드 저장
        racingGameRoundResult.add(new RacingGameRoundResult(carRoundResult));

        for (int i = SECOND_ROUND_NUM; i <= time; i++) {
            carRoundResult = new ArrayList<CarRoundResult>();
            moveCarPositionByGameRule(i, gameRule);
            racingGameRoundResult.add(new RacingGameRoundResult(carRoundResult));
        }

        return new RacingGameResult(racingGameRoundResult, time);
    }

    public void moveCarPositionByGameRule(int time, GameRule gameRule) {
        for (Car car : cars) {
            if (gameRule.moveRacingGameRule()) {
                car.move();
            }
            carRoundResult.add(new CarRoundResult(car.getCarName(), car.getMovePosition()));
        }
    }
}