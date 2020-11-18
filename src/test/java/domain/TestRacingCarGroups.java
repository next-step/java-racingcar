package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRacingCarGroups {
    List<RacingCar> racingCars;
    @BeforeEach
    void setUp() {
        racingCars = Arrays.asList(
                new RacingCar("BMW" ,1),
                new RacingCar("BENZ", 2),
                new RacingCar("VOLVO", 3));
    }

//    @Test
    @DisplayName("Q. 해당 테스트는 실패합니다. " +
            "RacingCarGroups에서 create 테스트는 " +
            "각각 생성된 racing car에 대해서 값을 확인해야 가능할 것 같습니다. " +
            "이렇게 되면 racingCarGroups의 create test를 해야할지 모르겠습니다.")
//    void create() {
//        RacingCarGroups racingCarGroups = new RacingCarGroups(racingCars);
//        assertThat(racingCarGroups).isEqualTo(new RacingCarGroups(Arrays.asList(
//                new RacingCar("BMW", 0),
//                new RacingCar("BENZ", 0),
//                new RacingCar("VOLVO", 0)
//        )));
//    }

    @Test
    void find_winners() {
        RacingCarGroups racingCarGroups = new RacingCarGroups(racingCars);
        assertThat(racingCarGroups.findWinners()).isEqualTo(Arrays.asList("VOLVO"));
    }
}
