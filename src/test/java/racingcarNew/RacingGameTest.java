package racingcarNew;

import org.junit.jupiter.api.Test;
import racingcarNew.domain.Car;
import racingcarNew.domain.Cars;
import racingcarNew.domain.RacingHistory;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private static final String USER_INPUT_CAR_NAMES = "pobi,wotjd,bk";
    private static final int USER_INPUT_RACING_LAP = 3;
    private static final int DEFAULT_CAR_POSITION = 0;

    @Test
    void 사용자가_입력한_이름의_숫자_만큼_자동차_대수를_생성() {
        RacingGame racingGame = new RacingGame(USER_INPUT_CAR_NAMES, USER_INPUT_RACING_LAP);
        Cars cars = racingGame.getRacingCars();
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 입력한_이름의_자동차가_생성됐는지_확인() {
        String carName = "pobi";
        Car car = new Car(carName, DEFAULT_CAR_POSITION);
        assertThat(car.getCarName()).isEqualTo(carName);
    }

}