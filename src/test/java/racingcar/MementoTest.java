/**
 * 클래스 이름: MementoTest
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Memento 클래스의 테스트")
class MementoTest {

    @ParameterizedTest
    @DisplayName("carArr.length 을 getCarNum 값이 같아야 한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void getCarNum(int carNum) {
        Car[] carArr = new Car[carNum];
        int tryNum = 5;
        Memento memento = new Memento(carArr, tryNum);
        assertThat(memento.getCarNum())
                .isEqualTo(carArr.length);
    }

    @ParameterizedTest
    @DisplayName("생성자의 tryNum 인자와 똑같이 maxTry 가 나와야 한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void getMaxTry(int tryNum) {
        int carNum = 5;
        Car[] carArr = new Car[carNum];
        Memento memento = new Memento(carArr, tryNum);
        assertThat(memento.getMaxTry())
                .isEqualTo(tryNum);
    }

    @ParameterizedTest
    @DisplayName("increaseCurrTry 를 한 만큼 currTry 가 증가해야 한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void increaseCurrTry(int loop) {
        int carNum = 3;
        int tryNum = 5;
        Car[] carArr = new Car[carNum];
        Memento memento = new Memento(carArr, tryNum);
        int oldCurrTry = memento.getCurrTry();
        for (int i = 0; i < loop; i++) {
            memento.increaseCurrTry();
        }
        assertThat(memento.getCurrTry())
                .isEqualTo(oldCurrTry + loop);
    }

    @ParameterizedTest
    @DisplayName(" 헤당 index 의 car 만 전진해야 한다.")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void moveCar(int carIdx) {
        int carNum = 10;
        int tryNum = 5;
        Car[] carArr = new Car[carNum];

        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);
        Mockito.when(strategy.proceed()).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocation) {
                return true;
            }
        });

        for (int i = 0; i < carNum; i++) {
            carArr[i] = new Car(strategy);
        }

        Memento memento = new Memento(carArr, tryNum);
        memento.moveCar(carIdx);

        int unMovedPosition = 1;
        int movedPosition = 2;

        for (int i = 0; i < carNum; i++) {

            assertThat(carArr[i].getPosition())
                    .isEqualTo((carIdx == i) ? movedPosition : unMovedPosition);
        }
    }
}
