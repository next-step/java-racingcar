package racing.domain.car.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.car.entity.fake.FakeBasicCar;
import racing.domain.car.vo.Location;
import racing.domain.car.vo.Name;
import racing.domain.car.vo.fuel.BasicFuel;
import racing.domain.car.vo.fuel.Fuel;
import racing.domain.car.vo.fuel.RandomFuel;

import static org.assertj.core.api.Assertions.*;

class BasicCarTest {
    private static Name anonymousName;

    @BeforeAll
    public static void setUp() {
        anonymousName = new Name("AAA");
    }

    @CsvSource({
            "0,100,0",
            "4,100,100",
            "9,100,100"
    })
    @DisplayName("Car Move 테스트 (BasicFuel 사용)")
    @ParameterizedTest
    public void moveTest(int fuelValue, int turnSize, int locationValue) {
        Location location = new Location(locationValue);
        BasicFuel fuel = new BasicFuel(fuelValue);

        Car car = new BasicCar(anonymousName);
        for (int i = 0; i < turnSize; i++)
            car.move(fuel);

        assertThat(
                car.checkLocation(location)
        ).withFailMessage("자동차가 요청한대로 행동하지 않았습니다.")
                .isTrue();
    }

    @CsvSource({
            "-1,100",
            "0,100",
            "10,100",
    })
    @DisplayName("Car Move IllegalArgumentException 테스트")
    @ParameterizedTest
    public void moveIllegalArgumentExceptionTest(int fuelValue, int turnSize) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                moveTest(fuelValue, turnSize, -1)
        );
    }

    @DisplayName("Car Clone Deep Copy 테스트 (RandomFuel 사용)")
    @Test
    public void cloneTest() {
        Fuel fuel = new RandomFuel();
        Car car = new FakeBasicCar(anonymousName);
        BasicCar cloneCar = (BasicCar) car.clone();

        cloneCar.move(fuel);
    }
}