package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    private String[] carNames;
    @BeforeEach
    public void setup() {
        carNames = new String[]{"pobi", "crong", "honux"};
    }

    @Test
    @DisplayName("자동차 대수를 입력받아 초기화하면 입력만큼 자동차들이 만들어진다")
    public void 자동차_대수를_입력받아_초기화하면_입력만큼_자동차들이_만들어진다() {
        //given
        //when
        RacingCars racingCars = RacingCars.create(carNames);
        //then
        assertThat(racingCars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("status가  주어졌을때 Status View를  확인한다")
    public void status가_주어졌을때_Status_View를_확인한다() {
        //given
        String result = CarsStatusHelper.getCarStatusView(3);
        //when
        //then
        assertThat(result).isEqualTo("---");
    }

    @Test
    public void RacingCars_중에서_우승자를_선출하면_1명_이상이_나온다(){
        //given
        RacingCars racingCars = RacingCars.create(new String[]{"pobi", "crong", "honux"});
        //when
        for (int i = 0; i < 5; i++) {
            racingCars.run();
        }
        List<String> winners = racingCars.getWinners();
        //then
        assertThat(winners.size()).isGreaterThanOrEqualTo(1);
    }
}
