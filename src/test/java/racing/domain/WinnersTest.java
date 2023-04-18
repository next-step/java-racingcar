package racing.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.FixedRandomForwardStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnersTest {
    private List<Car> carList;
    private Winners winners;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("pobi", new FixedRandomForwardStrategy(5)));
        carList.add(new Car("crong", new FixedRandomForwardStrategy(5)));
        carList.add(new Car("honux", new FixedRandomForwardStrategy(0)));
    }

    @AfterEach
    void tearDown() {
        carList = null;
        winners = null;
    }

    @Test
    @DisplayName("Winners 빈 리스트로 생성 시 예외처리")
    void create() {
        List<Car> customCarList = new ArrayList<>();
        assertThatThrownBy(() -> winners = new Winners(customCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input이 null입니다.");
    }

    @Test
    @DisplayName("Winners 자동차 리스트로 생성 테스트")
    void createWithCarList() {
        winners = new Winners(carList);
        assertThat(winners).isNotNull();
    }

    @Test
    @DisplayName("Winners 우승자 1명 테스트")
    void winnerNames1() {
        carList.get(0).move();

        Winners winners = new Winners(carList);
        List<Name> winnerNames = winners.toNames();
        assertThat(winnerNames).containsExactly(new Name("pobi"));
    }

    @Test
    @DisplayName("Winners 우승자 2명 이상 테스트")
    void winnerNames2() {
        int cycle = 3;
        for (int i = 0; i < cycle; i++) {
            carList.get(0).move();
            carList.get(1).move();
        }

        Winners winners = new Winners(carList);
        List<Name> winnerNames = winners.toNames();
        assertThat(winnerNames).containsExactly(new Name("pobi"), new Name("crong"));
    }
}
