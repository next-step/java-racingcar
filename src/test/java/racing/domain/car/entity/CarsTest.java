package racing.domain.car.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.car.entity.fake.FakeBasicCar;
import racing.domain.car.vo.Location;
import racing.domain.car.vo.Name;
import racing.domain.car.vo.fuel.BasicFuel;
import racing.domain.car.vo.fuel.Fuel;
import racing.domain.car.vo.fuel.RandomFuel;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarsTest {
    private static RandomFuel randomFuel;

    @BeforeAll
    public static void setUp() {
        randomFuel = new RandomFuel();
    }

    /*
    요구 사항은 ','를 기준으로 이름을 입력 받지만
    * @CsvSource의 기본 구분 문자가 ',' 이기 때문에
    * 테스트 에서는 이름 구분자를 '|' 로 변경
    */
    private static final String NAME_DELIMITER = "\\|";
    public Cars initCars(String strNames, Function<Name, Car> carCtor) {
        String[] strNameSplitValues = strNames.split(NAME_DELIMITER);

        return new Cars(
                Arrays.stream(strNameSplitValues)
                        .map(Name::new)
                        .map(carCtor)
                        .collect(Collectors.toSet())
        );
    }

    private String newAnonymousName(int identity) {
        return String.valueOf(identity);
    }

    private String sizeToNames(int size) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(
                    newAnonymousName(i)).append("|");
        }
        if (builder.length() > 0)
            return builder.substring(0, builder.length() - 1);
        return builder.toString();
    }

    @DisplayName("Car ctor (인자 없음) 테스트")
    @Test
    public void ctorTest() {
        assertThat(new Cars().isEmpty())
                .isTrue();
    }

    @ValueSource(ints = {
            10, 100, 1000
    })
    @DisplayName("Car ctor (Set 전달) 테스트")
    @ParameterizedTest
    public void ctorTest(int size) {
        Cars srcCars = initCars(
                sizeToNames(size),
                BasicCar::new
        );

        assertThat(srcCars.size())
                .isEqualTo(size);
    }

    @ValueSource(ints = {
            10, 100, 1000
    })
    @DisplayName("Car Add 테스트")
    @ParameterizedTest
    public void addTest(int size) {
        Cars srcCars = initCars(
                sizeToNames(size),
                BasicCar::new
        );
        Cars cars = new Cars();
        for (Car iCar : srcCars)
            cars.add(iCar);

        assertThat(cars.size())
                .isEqualTo(size);
    }

    @ValueSource(ints = {
            10, 100, 1000
    })
    @DisplayName("Car Add All 테스트")
    @ParameterizedTest
    public void addAllTest(int size) {
        Cars srcCars = initCars(
                sizeToNames(size),
                BasicCar::new
        );
        Cars cars = new Cars();
        cars.addAll(srcCars);

        assertThat(cars.size())
                .isEqualTo(size);
    }

    // 요구사항 "주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다." 에 대한 테스트를 추가 해보면 어떨까요?
    // 꼭 Cars가 아니여도 상관이 없습니다. 🤔
    @CsvSource({
            "5,100,0,0",
            "5,100,1,0",
            "5,100,2,0",
            "5,100,3,0",
            "5,100,4,100",
            "5,100,5,100",
            "5,100,6,100",
            "5,100,7,100",
            "5,100,8,100",
            "5,100,9,100"
    })
    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    public void moveAllTest(int carSize, int turnSize, int fuelValue, int locationValue) {
        Location location = new Location(locationValue);
        Cars cars = initCars(
                sizeToNames(carSize), BasicCar::new
        );
        BasicFuel basicFuel = new BasicFuel(fuelValue);

        for (int i = 0; i < turnSize; i++) {
            cars.moveAll(basicFuel);
        }

        for (Car iCar : cars) {
            assertThat(
                    iCar.checkLocation(location)
            ).withFailMessage("요청한대로 이동하지 않았습니다.")
                    .isTrue();
        }
    }

    @Test
    public void addTest() {
        Cars cars = new Cars();
        cars.add(
                new BasicCar(
                        new Name("AAA1")
                )
        );
        cars.add(
                new BasicCar(
                        new Name("AAA2")
                )
        );
        cars.add(
                new BasicCar(
                        new Name("AAA3")
                )
        );
    }

    @Test
    public void addTest_IllegalStateException() {
        assertThatThrownBy(() -> {
            Cars cars = new Cars();
            cars.add(
                    new BasicCar(
                            new Name("AAA")
                    )
            );
            cars.add(
                    new BasicCar(
                            new Name("AAA")
                    )
            );
            cars.add(
                    new BasicCar(
                            new Name("AAA")
                    )
            );
        }).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("bestCar Test")
    @CsvSource({
            "A|B|C,D,100000",
            "A|B|C,D|E,100000",
            "A|B|C|D|E|F,G|P|Q,1000000"
    })
    @ParameterizedTest
    public void bestCarsTest(String strBasicCarNames, String strFakeCarName, int turnSize) {
        Cars cars = initCars(strBasicCarNames, BasicCar::new);
        Cars fakeCars = initCars(strFakeCarName, FakeBasicCar::new);
        cars.addAll(fakeCars);

        // 이동
        for (int i = 0; i < turnSize; i++)
            cars.moveAll(randomFuel);

        Cars winners = cars.bestCars();
        for(Car iFakeCar : fakeCars) {
            assertThat(winners.contains(iFakeCar))
                    .withFailMessage("예상한 우승자가 포함되어 있지 않습니다.")
                    .isTrue();
        }
        assertThat(winners.size() == fakeCars.size())
                .withFailMessage("우승자의 수가 예상한 수와 다릅니다.")
                .isTrue();
    }

    @DisplayName("Deep Copy 테스트")
    @Test
    public void cloneTest() {
        Location resultLocation = new Location(100);
        Fuel randomFuel = new RandomFuel();

        Cars cars = initCars(sizeToNames(1), FakeBasicCar::new);
        Cars cloneCars = (Cars) cars.clone();

        cloneCars.moveAll(randomFuel);

        assertThat(cars.iterator().next().checkLocation(resultLocation))
                .withFailMessage("원본의 값도 같이 변경됨")
                .isFalse();
        assertThat(cloneCars.iterator().next().checkLocation(resultLocation))
                .withFailMessage("복사된 자동차가 움직이지 못함")
                .isTrue();
    }
}