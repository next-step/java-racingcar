package carracing.domain;

import carracing.service.dto.RacingScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    @DisplayName("Engine 클래스 - 랜덤값이 4 이상이면 반드시 움직인다")
    public void engine_move(int testParam) {
        // given
        Engine engine = new Engine(new Random() {
           @Override
           public int nextInt(int bound) {
               return testParam;
           }
        });

        // when then
        assertThat(engine.drive()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1, 0, -1, -2})
    @DisplayName("Engine 클래스 - 랜덤값이 4 미만이면 반드시 멈춘다")
    public void engine_stop(int testParam) {
        // given
        Engine engine = new Engine(new Random() {
            @Override
            public int nextInt(int bound) {
                return testParam;
            }
        });

        // when then
        assertThat(engine.drive()).isEqualTo(0);
    }

    @Test
    @DisplayName("Cars 생성 - 자동차 명 미입력 시 예외발생")
    public void cars() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new Cars("") )
                .withMessageMatching("경주에 참가할 자동차 명을 입력해 주세요.");
    }

    @Test
    @DisplayName("Car 생성 - 자동차 명 미입력 시 예외발생_공백입력")
    public void car_blankCarName() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new Car("  ") )
                .withMessageMatching("자동차 이름은 최소 1자 이상 입력되어야 합니다.");
    }

    @Test
    @DisplayName("Car 생성 - 자동차 명 미입력 시 예외발생_null 입력")
    public void car_nameIsNull() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new Car(null) )
                .withMessageMatching("자동차 이름은 최소 1자 이상 입력되어야 합니다.");
    }

    @Test
    @DisplayName("Car 생성 - 자동차 명 5자초과 불가")
    public void car_nameLengthIsGreaterThan5() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new Car("aaaaaa") )
                .withMessageMatching("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("Car 생성 - 공백 제외 문자길이 5이하인 경우 차량 생성 정상")
    public void car_nameWithBlank() {
        // given
        Car car = new Car(" aaaaa   ");
        String carName = car.inquiryRacingScore().getCarName();

        // when then
        assertThat(5).isEqualTo(carName.length());
    }

    @Test
    @DisplayName("경기점수 등록 - 참가 자동차 수와 경기스코어 수는 같아야 함")
    void registerRacingScore() {
        // given
        Cars cars = new Cars("pobi,crong,honux");
        List<RacingScore> racingScores = cars.inquiryRacingScores();

        // when
        cars.driveAll();

        // then
        assertThat(cars.getCarList().size()).isEqualTo(racingScores.size());
    }
}