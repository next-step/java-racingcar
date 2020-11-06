package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {


    @DisplayName("RaceCar 포지션 이동 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4, 5, 6, 8})
    public void racingCarsGetRoundResultTest(int moveCount) {
        //Given
        RacingCar racingCar = new RacingCar(new RandomCommander());

        //When
        for (int i = 0; i < moveCount; i++) {
            racingCar.executeMoveTrack();
            racingCar.movePosition();
        }

        //Then
        assertThat(racingCar.movePosition()).isLessThanOrEqualTo(moveCount);



    }


}
