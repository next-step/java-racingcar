package racingcar;

import domain.RacingCar;
import domain.RacingCarGroups;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRacingCarGroups {
    RacingCarGroups racingCarGroups;

    @BeforeEach
    void setUp() {
        HashMap<String, Integer> carInfo = new HashMap<String, Integer>(){{
            put("BMW", 4);
            put("BENZ", 3);
            put("VOLVO", 1);
        }};
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String name : carInfo.keySet()) {
            RacingCar racingCar = new RacingCar(name, carInfo.get(name));
            racingCarList.add(racingCar);
        }
        racingCarGroups = new RacingCarGroups(racingCarList);
    }

    @DisplayName("자동차그룹 생성")
    @ParameterizedTest
    @CsvSource({"3"})
    void test_create_racing_cars(int result) {
        assertThat(racingCarGroups.getRacingCars().size())
                .isEqualTo(result);
    }

    @DisplayName("자동차그룹 이동")
    @ParameterizedTest
    @CsvSource({"4"})
    void test_move(int result) {
        racingCarGroups.move();
        assertThat(racingCarGroups.getRacingCars().get(0).getCarDistance().getDistance())
                .isLessThanOrEqualTo(result);
    }

    @DisplayName("우승자 찾기")
    @ParameterizedTest
    @CsvSource({"BMW"})
    void test_get_find_winners(String winner) {
        assertThat(racingCarGroups.findWinners()).isEqualTo(new ArrayList<String>() {{
            add(winner);
        }});
    }
}
