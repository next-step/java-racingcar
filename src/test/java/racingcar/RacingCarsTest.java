package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.collection.CarCollection;
import racingcar.domain.value.CarName;
import racingcar.domain.value.Position;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<String> carName = Arrays.asList("lee","kim","tt");
        List<RacingCar> car = CarCollection.racingGameReady(carName);

        racingCars = RacingCars.create(car);
    }

    @Test
    @DisplayName("자동차 여러대를 입력했을 경우 잘 입력 되었는지 확인")
    void setArrayCarName() {

        assertThat(racingCars.getCars().contains(new RacingCar("lee"))).isTrue();
        assertThat(racingCars.getCars().contains(new RacingCar("kim"))).isTrue();
    }

    @Test
    @DisplayName(("우승자를 찾아보기"))
    void getVitoryName() {

        RacingCar car1 = new RacingCar(Position.create(3), CarName.create("lee"));
        RacingCar car2 = new RacingCar(Position.create(3), CarName.create("kim"));
        RacingCar car3 = new RacingCar(Position.create(1), CarName.create("joo"));

        String winner = "lee,kim";

        RacingCars cars = RacingCars.create(Arrays.asList(car1,car2,car3));
        String result = cars.getVictoryUsers();

        assertThat(result).isEqualTo(winner);
    }
}
