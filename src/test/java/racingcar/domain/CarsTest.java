package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarsTest {
    @Test
    @DisplayName("자동차 이름 및 생성 횟수 확인")
    void createCars() {
        Cars cars = new Cars("mk,jk,num");
        List<Car> createCars = cars.getCars();
        assertThat(createCars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("런 테스트")
    void runTest() {
        Cars cars = new Cars("fk,fkfk,mkkim");
        cars.run();
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 값 널 유효성 체크")
    @NullAndEmptySource
    void validNullInputNames(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Cars(names);
        })
                .withMessageContaining("값이 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 구분자 체크")
    void validSeparator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Cars("mkkim");
        })
                .withMessageContaining("자동차 이름 구분자 쉼표(,)가 없습니다.");
    }

    @Nested
    @DisplayName("최종우승자 찾기")
    class Winners {
        Car car1;
        Car car2;
        Car car3;
        Car car4;

        @BeforeEach
        void setUp() {
            car1 = new Car(new Name("mkkim")) {
                @Override
                public int position() {
                    return 3;
                }
            };
            car2 = new Car(new Name("pobi")) {
                @Override
                public int position() {
                    return 5;
                }
            };
            car3 = new Car(new Name("woowa")) {
                @Override
                public int position() {
                    return 7;
                }
            };
            car4 = new Car(new Name("revie")) {
                @Override
                public int position() {
                    return 7;
                }
            };
        }

        @Test
        @DisplayName("최종 우승자로 선별")
        void getWinners() {
            Cars cars = new Cars(Arrays.asList(car1, car2, car3, car4));
            List<Car> winners = cars.getWinners();
            assertThat(winnerName(winners)).isEqualTo("woowa,revie");
        }

        String winnerName(List<Car> cars) {
            final String separator = ",";
            return cars.stream().map(Car::name)
                    .collect(Collectors.joining(separator));
        }

    }
}
