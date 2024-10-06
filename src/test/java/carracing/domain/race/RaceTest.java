package carracing.domain.race;

import carracing.domain.car.Car;
import carracing.domain.car.Name;
import carracing.domain.car.Position;
import carracing.domain.move.ForwardStrategy;
import carracing.domain.move.MoveStrategy;
import carracing.domain.move.StopStrategy;
import carracing.domain.record.RoundRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @DisplayName("이름 리스트로 자동차들을 초기화 할 수 있다")
    @Test
    void of() {
        MoveStrategy moveStrategy = new StopStrategy();
        List<String> carNames = List.of("green", "blue", "red");
        List<Car> expected = List.of(
                Car.of(Name.from("green"), Position.from(1)),
                Car.of(Name.from("blue"), Position.from(1)),
                Car.of(Name.from("red"), Position.from(1))
        );

        Race race = Race.of(carNames, 1, moveStrategy);

        assertThat(race.getCars())
                .hasSize(3)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @DisplayName("난수값이 4이상이면 자동차를 1만큼 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9, 100})
    void moveCars(int randomNumber) {
        MoveStrategy moveStrategy = new ForwardStrategy();
        List<String> carNames = List.of("green");
        Race race = Race.of(carNames, 1, moveStrategy);

        List<RoundRecord> expected = List.of(
                RoundRecord.from(List.of(Car.of(Name.from("green"), Position.from(1)))),
                RoundRecord.from(List.of(Car.of(Name.from("green"), Position.from(2))))
        );

        List<RoundRecord> result = race.start();

        assertThat(result)
                .hasSize(2)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @DisplayName("3대의 자동차 목록에서 3라운드동안 이동한 결과를 반환 받을 수 있다.")
    @Test
    void getCarRecords() {
        MoveStrategy moveStrategy = new ForwardStrategy();
        List<String> carNames = List.of("green", "blue", "red");
        Race race = Race.of(carNames, 3, moveStrategy);

        List<RoundRecord> expected = List.of(
                RoundRecord.from(List.of(Car.of(Name.from("green"), Position.from(1)), Car.of(Name.from("blue"), Position.from(1)), Car.of(Name.from("red"), Position.from(1)))),
                RoundRecord.from(List.of(Car.of(Name.from("green"), Position.from(2)), Car.of(Name.from("blue"), Position.from(2)), Car.of(Name.from("red"), Position.from(2)))),
                RoundRecord.from(List.of(Car.of(Name.from("green"), Position.from(3)), Car.of(Name.from("blue"), Position.from(3)), Car.of(Name.from("red"), Position.from(3)))),
                RoundRecord.from(List.of(Car.of(Name.from("green"), Position.from(4)), Car.of(Name.from("blue"), Position.from(4)), Car.of(Name.from("red"), Position.from(4))))
        );

        List<RoundRecord> result = race.start();

        assertThat(result)
                .hasSize(4)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}