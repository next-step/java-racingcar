package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTests {
    @DisplayName("기록판에 기록이 잘 입력되는지 테스트")
    @Test
    void boardRecordTest() {
        Car car1 = new Car(new Name("pobi"), new Position(5));
        Car car2 = new Car(new Name("crong"), new Position(3));
        Car car3 = new Car(new Name("honux"), new Position(5));

        Cars cars = Cars.of(Arrays.asList(car1, car2, car3));

        Board board = new Board();
        board.record(cars);

        List<Name> actualCarNames = board.getRacingCarNames();
        List<Position> actualAllRecords = board.getRacingCarPositions();

        assertThat(actualCarNames.toString()).isEqualTo("[pobi, crong, honux]");
        assertThat(actualAllRecords.toString()).isEqualTo("[5, 3, 5]");
    }
}
