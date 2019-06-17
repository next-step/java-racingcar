package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;
    private static final String CAR_NAME = "feelydh,dhlee,jwlee";

    @BeforeEach
    void init(){
        racingGame = new RacingGame();
        racingGame.carPositionsInit(CAR_NAME);
    }

    @Test
    @DisplayName("postion 값 셋팅 테스트(처음 position 무조건 1로 셋팅)")
    void firstMoveTest() {
        List<CarDto> carPositionList = racingGame.move();
        for(CarDto carDto : carPositionList){
            assertThat(carDto.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("랜덤 숫자에 따른 자동차 움직임 테스트")
    void carPositionUpdateValueTest() {
        Random generator = new Random();
        int randomNumber = generator.nextInt(10);
        int moveNumber = racingGame.carPositionUpdateValue(randomNumber);

        assertThat(randomNumber > 3).isEqualTo(moveNumber == 1);
        assertThat(randomNumber < 4).isEqualTo(moveNumber == 0);
    }
}
