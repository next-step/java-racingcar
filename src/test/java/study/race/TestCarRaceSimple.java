package study.race;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCarRaceSimple {


    @ParameterizedTest
    @CsvSource({"2, 4", "4, 5", "3, 6"})
    @DisplayName("CarRace 입력 Car 개수 입력 테스트")
    public void test_carrace_carNum_tryNum_input(int carNum, int tryNum) {
        CarRace race = new CarRace(carNum, tryNum);

        assertThat(race.getCars().size()).isEqualTo(carNum);
    }


    @ParameterizedTest
    @CsvSource({"2, 4", "4, 5", "3, 6"})
    @DisplayName("CarRace 실행 테스트")
    public void test_carrace_run(int carNum, int tryNum) {
        CarRace race = new CarRace(carNum, tryNum);
        race.run();

        List<Car> cars = race.getCars();
        for (Car car : cars) {
            assertThat(car.getMoveHistory().size()).isEqualTo(tryNum);
        }
    }

}
