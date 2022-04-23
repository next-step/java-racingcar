package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RacingCarTest {

    @Test
    @DisplayName("입력한 자동차 이름 개수만큼 RacingCar 객체 생성되는지 확인")
    void createBatch() {
        RacingCar[] racingCars = RacingCar.createBatch(new String[]{"cool", "good", "amaz"});

        Assertions.assertThat(racingCars).hasSize(3);
    }

    @Test
    @DisplayName("입력한 자동차 이름대로 RacingCar 객체 생성되는지 확인")
    void createBatchCarName() {
        RacingCar[] racingCars = RacingCar.createBatch(new String[]{"cool", "good", "amaz"});

        Assertions.assertThat(racingCars[0].getName()).isEqualTo("cool");
        Assertions.assertThat(racingCars[1].getName()).isEqualTo("good");
        Assertions.assertThat(racingCars[2].getName()).isEqualTo("amaz");
    }

    @Test
    @DisplayName("입력한 자동차 이름이 5자 초과할 경우 예외 발생")
    void validateCarName() {
        Assertions.assertThatThrownBy(() -> RacingCar.createBatch(new String[]{"tddWithJava", "good", "amaze"}))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

}