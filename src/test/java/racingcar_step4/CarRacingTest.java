package racingcar_step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("초간단 자동차 경주 테스트")
public class CarRacingTest {

    private String names;
    private int racingCount;
    private Car car;

    @BeforeEach
    void init(){
        this.names = "car1,car2,car3";
        this.racingCount = 5;
        this.car = new Car(names);
    }

    @Test
    @DisplayName("Test1 자동차 이동")
    void carMoveOne() {
        car.move();
        int moveDistance = car.getTotalDistance();
        assertThat(moveDistance).isEqualTo(1);
    }

    @Test
    @DisplayName("Test2 자동차 랭킹")
    public void carRankTest() {
        List<Car> cars = Arrays.asList(new Car("car1", 3)
                , new Car("car2", 2)
                , new Car("car3", 5));

        RacingCarRank racingCarRank = new RacingCarRank();
        List<Car> winners = racingCarRank.rankCars(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly(cars.get(0));
    }

    @Test
    @DisplayName("Test3 자동차 모두 동점")
    public void allWinners() {
        List<Car> cars = Arrays.asList(new Car("car1", 5)
                , new Car("car2", 5)
                , new Car("car3", 5));

        RacingCarRank racingCarRank = new RacingCarRank();
        List<Car> winners = racingCarRank.rankCars(cars);

        assertThat(winners).hasSize(3);
        assertThat(winners).containsExactly(cars.get(0), cars.get(1), cars.get(2));
    }

    @Test
    @DisplayName("Test4 자동차 이름 정규식 오류")
    public void checkPatternTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.checkPattern(",car2,car3");
        });
    }
}
