package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingSheetTest {

    @Test
    @DisplayName("각 스냅샷이 힙 영역의 같은값을 안바라보는지 테스트 한다.")
    void snapshot_test() {

        RacingSheet racingSheet = new RacingSheet();

        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        Cars cars = new Cars(Arrays.asList(carA, carB, carC));

        racingSheet.addSheet(cars);
        racingSheet.addSheet(cars);

        List<Cars> racingSheets = racingSheet.getRacingSheets();

        Cars firstSnapshot = racingSheets.get(0);
        Cars secondSnapshot = racingSheets.get(1);

        assertThat(firstSnapshot).isNotEqualTo(secondSnapshot);
    }
}