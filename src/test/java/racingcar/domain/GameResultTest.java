package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("GameResult 클래스 테스트")
public class GameResultTest {

    @Test
    @DisplayName("getResult 메소드는 자동차의 위치를 문자로 변환 후 리턴한다.")
    void getResult() {
        // given
        String carName1 = "테스터";

        Cars cars = Cars.createCars(carName1);
        cars.carRacing(new FixedNumberStrategy());

        GameResult gameResult = new GameResult(cars);

        // when
        String actual = gameResult.getResult();

        // then
        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual).isEqualTo(carName1 + " : -" )
        );
    }
}
