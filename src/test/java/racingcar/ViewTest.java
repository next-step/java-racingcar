/**
 * 클래스 이름: ViewTest
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("View 클래스 테스트")
class ViewTest {

    View view;

    @BeforeEach
    void setUp() {
        Memento memento = Mockito.mock(Memento.class);
        this.view = new View(memento);
    }

    @ParameterizedTest
    @DisplayName("car 가 움직인만큼 -가 출력되어야 한다.")
    @CsvSource(value = {"0:-", "1:--", "2:---", "3:----", "4:-----", "5:------", "6:-------"}, delimiter = ':')
    void convertCarPositions(int loop, String expectedResult) {
        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);
        Mockito.when(strategy.proceed()).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocation) {
                return true;
            }
        });
        Car car = new Car(strategy);

        for (int i = 0; i < loop; i++) {
            car.move();
        }

        String result = this.view.convertCar(car);
        assertThat(result)
                .isEqualTo(expectedResult);

    }
}
