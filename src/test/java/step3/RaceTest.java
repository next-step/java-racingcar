package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceTest {

    @Test
    @DisplayName("사용자 입력만큼 자동차가 생성됩니다.")
    void testCreateCarsByInput() {
        int carCount = 3;

        Race race = new Race(carCount, 5);

        assertThat(race.getCars()).hasSize(carCount);
    }

    @Test
    @DisplayName("자동차를 한 칸 앞으로 이동시킬 수 있다.")
    void testMoveCar() {
        Car car = new Car();
        int originalPosition = car.getPosition();

        car.move();

        assertEquals(originalPosition + 1, car.getPosition());
    }

    @Test
    @DisplayName("경주가 끝난 자동차의 위치는 round 수 초과이거나 음수일 수 없다")
    void testCarCanNotMoveBeyondRound() {
        int raceRound = 5;
        Race race = new Race(1, raceRound);

        race.start();

        for (Car car : race.getCars()) {
            assertThat(car.getPosition()).isLessThanOrEqualTo(raceRound);
            assertThat(car.getPosition()).isNotNegative();
        }
    }
}
