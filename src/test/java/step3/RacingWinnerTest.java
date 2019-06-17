package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingWinnerTest {

    private List <CarDto> CAR_LIST;

    @BeforeEach
    void init() {
        CAR_LIST = new ArrayList <>();
        String[] carNameArray = new String[]{"feelydh", "dhlee", "jwlee"};
        int[] carPositionArray = new int[]{0, 1, 1};

        CarDto carDto;
        String carName;
        int carPosition;
        int carNumber = carNameArray.length;
        for (int i = 0; i < carNumber; i++) {
            carName = carNameArray[i];
            carPosition = carPositionArray[i];
            carDto = new CarDto(carName);
            carDto.setUpdatePosition(1);
            carDto.setUpdatePosition(carPosition);
            CAR_LIST.add(carDto);
        }
    }

    @Test
    @DisplayName("우승자 이름 정보 가져오는 테스트")
    void racingWinnerTest() {
        RacingWinner winnerResult = new RacingWinner();
        String winners = winnerResult.racingWinner(CAR_LIST);
        assertThat(winners).isEqualTo("dhlee, jwlee");
    }

    @Test
    @DisplayName("가장 높은 position 정보 가져오는 테스트")
    void maxPostionTest() {
        RacingWinner winnerResult = new RacingWinner();
        int maxPostion = winnerResult.maxPostion(CAR_LIST);
        assertThat(maxPostion).isEqualTo(2);
    }

}
