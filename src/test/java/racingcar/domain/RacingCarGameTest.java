package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("RacingCarGameTest 클래스 테스트")
public class RacingCarGameTest {

    @Test
    @DisplayName("execute 메소드는 레이싱 게임을 실행한다.")
    void execute() {
        // given
        String carName = "테스터";
        int moveCount = 2;
        RacingCarGame racingCarGame = new RacingCarGame(carName, moveCount);

        // when
        racingCarGame.execute(new FixedNumberStrategy());
        Cars cars = racingCarGame.getCars();

        // then
        assertAll(
                () -> assertThat(cars).isNotNull(),
                () -> assertThat(cars.getSize()).isEqualTo(carName.split(",").length),
                () -> assertThat(cars.getCars().get(0).getPosition()).isEqualTo(moveCount)
        );

    }
}
