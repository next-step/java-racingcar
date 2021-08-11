package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {

    private CarRace carRace;

    @BeforeEach
    void setUp() {
        carRace = new CarRace(3,5);
    }

    @Test
    @DisplayName("랜덤숫자 테스트")
    void getRandomNumTest() {
        assertThat(RandomNum.getRandomNum()).isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("createCarList 테스트")
    void createCarListTest() {
        //then
        assertThat(carRace.createCarList().getCarList().get(0).getDistance()).contains("");
    }

    @Test
    @DisplayName("playGame 테스트")
    void playGameTest() {
        //then
        carRace.playGame();
    }

}