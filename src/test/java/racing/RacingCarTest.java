package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingCarTest {
    
    @DisplayName("이동 성공 시 위치 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5})
    void twiceAttackPosition(int attackCount) {
        RacingCar racingCar = new RacingCar("LEC");
        for(int i = 0; i < attackCount; i++) {
            racingCar.attack(true);
        }

        assertThat(racingCar.getPosition().getPoistion()).isEqualTo(attackCount);
    }

    @DisplayName("위치에 따른 정보 출력 확인")
    @Test
    void printPositionTest() {
        RacingCar racingCar = new RacingCar("LEC");
        racingCar.attack(true);
        racingCar.attack(false);
        racingCar.attack(true);

        String actual = racingCar.printPosition();

        assertThat(actual).isEqualTo("LEC : --");
    }

}