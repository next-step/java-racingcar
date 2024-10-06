package carracing.domain.record;

import carracing.domain.car.Car;
import carracing.domain.car.Name;
import carracing.domain.car.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundRecordTest {

    @DisplayName("3대의 자동차 목록에서 3라운드동안 가장 멀리 이동한 자동차 1대를 찾을 수 있다.")
    @Test
    void getOneWinner() {
        Car green = Car.of(Name.from("green"), Position.from(3));
        Car blue = Car.of(Name.from("blue"), Position.from(4));
        Car red = Car.of(Name.from("red"), Position.from(5));
        RoundRecord roundRecord = RoundRecord.from(List.of(green, blue, red));

        List<Car> result = roundRecord.getLeadingCar();

        assertThat(result)
                .hasSize(1)
                .containsExactlyInAnyOrder(
                        Car.of(Name.from("red"), Position.from(5)
                        ));
    }

    @DisplayName("3대의 자동차 목록에서 3라운드동안 가장 멀리 이동한 자동차 2대를 찾을 수 있다.")
    @Test
    void getTwoWinners() {
        Car green = Car.of(Name.from("green"), Position.from(3));
        Car blue = Car.of(Name.from("blue"), Position.from(4));
        Car red = Car.of(Name.from("red"), Position.from(4));
        RoundRecord roundRecord = RoundRecord.from(List.of(green, blue, red));

        List<Car> result = roundRecord.getLeadingCar();

        assertThat(result)
                .hasSize(2)
                .containsExactlyInAnyOrder(
                        Car.of(Name.from("blue"), Position.from(4)),
                        Car.of(Name.from("red"), Position.from(4))
                );

    }

    @DisplayName("3대의 자동차 목록에서 3라운드동안 가장 멀리 이동한 자동차 3대를 찾을 수 있다.")
    @Test
    void getThreeWinners() {
        Car green = Car.of(Name.from("green"), Position.from(4));
        Car blue = Car.of(Name.from("blue"), Position.from(4));
        Car red = Car.of(Name.from("red"), Position.from(4));
        RoundRecord roundRecord = RoundRecord.from(List.of(green, blue, red));

        List<Car> result = roundRecord.getLeadingCar();

        assertThat(result)
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        Car.of(Name.from("blue"), Position.from(4)),
                        Car.of(Name.from("red"), Position.from(4)),
                        Car.of(Name.from("green"), Position.from(4))
                );
    }

}