package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    Race mockRace;
    String[] mockCars;

    @BeforeEach
    void setUp() {
        mockCars = new String[2];
        mockCars[0] = "mockCar1";
        mockCars[1] = "mockCar2";

        mockRace = new Race();
        int mockRounds = 3;
        mockRace.setUpRace(mockCars, mockRounds);
    }

    @Test
    @DisplayName("레이스를 시작하면 레이스에 필요한 세팅 성공")
    void createRace() {
        assertThat(
                mockRace.getCars().size())
                .isEqualTo(2);
        assertThat(
                mockRace.getNumOfRounds())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("레이스 한 라운드 실행")
    void runRace() {
        mockRace.runOneRound();
    }

    @Test
    @DisplayName("우승자의 이름을 가져오는데 성공")
    void getRaceWinnersSuccess() {
        Set<Car> cars = mockRace.getCars();
        Car car1 = cars.stream().findFirst().get();
        car1.move(true);

        assertThat(
                mockRace.getRaceWinners())
                .isEqualTo("mockCar1");

    }
}
