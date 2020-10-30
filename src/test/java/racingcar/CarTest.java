/**
 * 클래스 이름: CarTest
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 클래스의 테스트")
class CarTest {

    @Test
    @DisplayName("proceed 가 true 일 경우만 전진해야 한다.")
    void move() {
        MoveStrategy proceedStrategy = Mockito.mock(MoveStrategy.class);
        Mockito.when(proceedStrategy.proceed()).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocation) {
                return true;
            }
        });
        Car proceededCar = new Car(proceedStrategy);

        MoveStrategy stopStrategy = Mockito.mock(MoveStrategy.class);
        Mockito.when(stopStrategy.proceed()).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocation) {
                return false;
            }
        });
        Car stoppedCar = new Car(stopStrategy);


        proceededCar.move();
        stoppedCar.move();

        int proceededPosition = 2;
        int stoppedPosition = 1;
        assertThat(proceededCar.getPosition())
                .isEqualTo(proceededPosition);
        assertThat(stoppedCar.getPosition())
                .isEqualTo(stoppedPosition);
    }
}
