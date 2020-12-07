package racing.infra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.CarFactory;
import racing.domain.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("넥스트스탭 자동차 공장(NextStepCarFactory)")
class NextStepCarFactoryTest {

    @DisplayName("[X] ',' 구분자로 자동차를 만들 수 있습니다.")
    @Test
    void create() {
        // given
        String names = "pobi,yohan";
        CarFactory nextStepCarFactory = new NextStepCarFactory();

        // when
        Cars cars = nextStepCarFactory.create(names);

        // then
        assertThat(cars).isEqualTo(new Cars(Arrays.asList(Car.of("pobi"), Car.of("yohan"))));
    }
}
