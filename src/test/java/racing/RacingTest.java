package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private Racing racing;
    private int totalRound;
    private int carCount;

    @BeforeEach
    void 기본_설정(){
        totalRound = 5;
        carCount = 5;
        racing = new Racing(carCount, totalRound);
    }

    @Test
    void 라운드_끝나면_라운드의_결과를_반환() {
        CarsDTO carsDTO = racing.play();
        assertThat(carsDTO.getCars().size()).isEqualTo(carCount);
    }


    @Test
    void 자동차_경주는_이동횟수만큼_진행() {
        for (int idx = 0; idx < totalRound; idx++) {
            assertThat(racing.isEnd()).isEqualTo(false);
            CarsDTO carsDTO = racing.play();
        }
        assertThat(racing.isEnd()).isEqualTo(true);
    }


}
