package study.step3;


import java.util.Random;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class CarTest {

    @ParameterizedTest(name = "자동차 전진 조건 테스트: {arguments}")
    @ValueSource(ints = {4, 7, 9})
    void 자동차_전진_조건_테스트(int randomValue) {
        Random mockRandom = Mockito.mock(Random.class);
        given(mockRandom.nextInt(10)).willReturn(randomValue);

        Car car = new Car(mockRandom);
        int previousPosition = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isEqualTo(previousPosition + 1);
    }

    @ParameterizedTest(name = "자동차 정지 조건 테스트: {arguments}")
    @ValueSource(ints = {0, 1, 3})
    void 자동차_정지_조건_테스트(int randomValue) {
        Random mockRandom = Mockito.mock(Random.class);
        given(mockRandom.nextInt(10)).willReturn(randomValue);

        Car car = new Car(mockRandom);
        int previousPosition = car.getPosition();
        car.move();
        assertThat(car.getPosition()).isEqualTo(previousPosition);
    }
}
