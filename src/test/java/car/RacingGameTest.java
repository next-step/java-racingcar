package car;

import car.entity.Car;
import car.entity.CarJudgeStatus;
import car.entity.GameResult;
import car.entity.RacingGame;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    static final int INITIAL_CAR_COUNT = 3;
    static final int NOT_MOVING_RANDOM_NUM = 3;
    static final int MOVING_RANDOM_VALUE = 4;

    @Test
    public void 게임_초기화() {
        String[] carNames = {"test1", "test2", "test3"};
        RacingGame racingGame = new RacingGame(carNames);
        assertThat(racingGame.racingCars.size()).isEqualTo(carNames.length);
    }

    @Test
    public void 차_움직임_기준치보다_낮을_때_움직이지않음() {
        Car testCar = Car.getCarInstance("test1");
        testCar.move(NOT_MOVING_RANDOM_NUM);

        assertThat(testCar.movingCount).isEqualTo(0);
    }

    @Test
    public void 차_움직임_기준치보다_높을_때_움직임() {
        Car testCar = Car.getCarInstance("test1");
        testCar.move(MOVING_RANDOM_VALUE);

        assertThat(testCar.movingCount).isEqualTo(1);
    }

    @Test
    public void 승자_확인하기() {
        String[] carNames = {"test1", "test2", "test3"};
        int[] movingCounts = {0,0,100};

        List<Car> cars = createRacingCar(carNames, movingCounts);
        GameResult gameResult = GameResult.createResultInstance(cars);

        assertThat(gameResult.getGameWinner().get(0).name).isEqualTo(carNames[carNames.length-1]);
    }

    public List<Car> createRacingCar(String[] carNames, int[] movingCounts) {
        List<Car> cars = new ArrayList<>();

        for(int i=0; i < carNames.length; i++) {
            Car car = Car.getCarInstance(carNames[i]);
            car.movingCount = movingCounts[i];
            cars.add(car);
        }

        return cars;
    }

    @Test
    public void MAX값과_자신의_MOVINGCOUNT_비교_승리() {
        Car car = Car.getCarInstance("test");
        car.movingCount = 5;
        CarJudgeStatus status = car.judgeMaxMovement(4);
        assertThat(status).isEqualTo(CarJudgeStatus.WIN);
    }

    @Test
    public void MAX값과_자신의_MOVINGCOUNT_비교_패배() {
        Car car = Car.getCarInstance("test");
        car.movingCount = 3;
        CarJudgeStatus status = car.judgeMaxMovement(4);
        assertThat(status).isEqualTo(CarJudgeStatus.LOSE);
    }

    @Test
    public void MAX값과_자신의_MOVINGCOUNT_비교_무승부() {
        Car car = Car.getCarInstance("test");
        car.movingCount = 4;
        CarJudgeStatus status = car.judgeMaxMovement(4);
        assertThat(status).isEqualTo(CarJudgeStatus.DRAW);
    }
}