package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    private List<RacingCar> racingCars;


    @BeforeEach
    public void setUp() {
        racingCars = new ArrayList<>();
        racingCars.add(new RacingCar());
    }


    @Test
    @DisplayName("랜덤 값이 4 이상일 경우 차는 한 칸 전진한다.")
    public void givenIntOverFour_racingCarShouldBeMoveForward() {
        FakeRandom fakeRandom = new FakeRandom(4);
        NumberUtil numberUtil = new NumberUtil(fakeRandom);
        RacingCarGame racingCarGame = new RacingCarGame(numberUtil);

        racingCarGame.race(racingCars);

        assertThat(racingCars.get(0).getPosition()).isEqualTo(1);
    }
}
