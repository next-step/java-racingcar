package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerRacingCarsTest {
    @Test
    @DisplayName("우승차 문구를 반환하는 테스트")
    void winnerCarsStringTest() {

        List<String> winnerCarList = new ArrayList<>();
        winnerCarList.add("CarA");
        winnerCarList.add("CarB");
        WinnerRacingCars winnerRacingCars = new WinnerRacingCars(winnerCarList);

        assertThat(winnerRacingCars.toString()).isEqualTo("CarA, CarB가 최종 우승했습니다.");
    }
}
