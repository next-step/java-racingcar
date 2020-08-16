package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.RacingGame;
import step3.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    private Map<String, Car> carInfoMap;

    @BeforeEach
    void setUp() {
        carInfoMap = new HashMap<>();
    }

    @Test
    @DisplayName("게임에 참여하는 자동차")
    void prepareGame() {
        carInfoMap = RacingGame.preparationForGame(new String[]{"pobi", "crong", "honux"});
        
        assertThat(carInfoMap).hasSize(3);
        assertThat(carInfoMap).containsKey("pobi");
        assertThat(carInfoMap).containsKey("crong");
        assertThat(carInfoMap).containsKey("honux");
    }

    @Test
    @DisplayName("6글자 이상의 자동차 이름이 입력되면 IllegalArgumentException 발생")
    void invalidCarName() {
        assertThatThrownBy(() -> {
            ValidationCarName.carNameInvalidException("hangyeol");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 전진 조건 확인")
    void accelateTest() {
        carInfoMap = RacingGame.preparationForGame(new String[]{"tommy"});
        Car car = carInfoMap.get("tommy");
        int position = car.move(4, RacingRule.MOVEMENT_POLICY);

        assertThat(position).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 정지 조건 확인")
    void brakeTest() {
        carInfoMap = RacingGame.preparationForGame(new String[]{"tommy"});
        Car car = carInfoMap.get("tommy");
        int position = car.move(3, RacingRule.MOVEMENT_POLICY);

        assertThat(position).isEqualTo(0);
    }

    @Test
    @DisplayName("우승자 이동거리 확인")
    void winnerMileAge() {
        carInfoMap.put("tommy", new RacingCar("tommy", 7));
        carInfoMap.put("pobi", new RacingCar("pobi", 4));
        carInfoMap.put("crong", new RacingCar("crong", 7));
        int maxPosition = Winners.findMaxPosition(carInfoMap);

        assertThat(maxPosition).isEqualTo(7);
    }

    @Test
    @DisplayName("우승자 확인")
    void findWinners() {
        carInfoMap.put("tommy", new RacingCar("tommy", 7));
        carInfoMap.put("pobi", new RacingCar("pobi", 4));
        carInfoMap.put("crong", new RacingCar("crong", 7));
        int maxPosition = Winners.findMaxPosition(carInfoMap);
        List<String> winners = Winners.findWinners(carInfoMap, maxPosition);

        assertThat(winners).contains("crong");
        assertThat(winners).contains("tommy");
    }

}
