package racingcar.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.domain.Car;
import racingcar.step3.domain.Cars;
import racingcar.step3.move.Moving;
import racingcar.step3.service.RacingGame;
import racingcar.step3.validator.CarValidator;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Moving moving;

    @BeforeEach
    void init() {
        AppConfig appConfig = new AppConfig();
        moving = appConfig.move();
    }

    @Test
    @DisplayName("값 찍어서 테스트 - 4이상 9이하면 움직인다")
    void carMove() {
        Car car = new Car(1);
        car.move(4);
        car.move(9);
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("값 찍어서 테스트 - 4이상 9이하가 아니면 멈춘다")
    void carStop() {
        Car car = new Car(1);
        car.move(3);
        car.move(10);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("값은 음수가 들어오면 안된다")
    void inputValidation() {
        assertThatThrownBy(() -> CarValidator.countOfTryCheck(-1))
                .isInstanceOf(IllegalArgumentException.class);
        //값 정상
        assertThatCode(() -> CarValidator.countOfTryCheck(1))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("랜덤값 테스트 - 4이상이면 움직인다")
    void carMoveRandom() {
        Car car = new Car(1);
        car.move(new Moving() {
            @Override
            public boolean isMovable() {
                return true;
            }
        });
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("랜덤값 테스트 - 레이스 테스트")
    void race() {
        Cars cars = new Cars(3);
        RacingGame racingGame = new RacingGame(10, cars);
        racingGame.race(moving);
        assertThat(racingGame.getCountOfTry()).isEqualTo(9);
        assertThat(racingGame.isEndGame()).isFalse();
    }

    @Test
    @DisplayName("랜덤값 테스트 - 종료 테스트")
    void endGame() {
        Cars cars = new Cars(3);
        RacingGame racingGame = new RacingGame(10, cars);
        for (int i = 0; i < 10; i++) {
            racingGame.race(moving);
        }
        assertThat(racingGame.isEndGame()).isTrue();
    }

}
