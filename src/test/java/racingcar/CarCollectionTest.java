package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class CarCollectionTest {

    @ParameterizedTest
    @DisplayName("입력받은 carNum 과 getCarNum 값이 같아야 한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void getCarNum(int carNum) {
        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);
        CarCollection collection = new CarCollection(carNum, strategy);
        assertThat(collection.getCarNum())
                .isEqualTo(carNum);
    }

    @ParameterizedTest
    @DisplayName("carIndex 의 car 만 전진해야 한다.")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void moveCar(int carIdx) {
        int carNum = 10;
        MoveStrategy strategy = new MoveStrategy() {
            @Override
            public boolean checkMovable() {
                return true;
            }
        };

        CarCollection collection = new CarCollection(carNum, strategy);
        collection.moveCar(carIdx);

        int unMovedPosition = 1;
        int movedPosition = 2;

        Executable[] executables = new Executable[carNum];
        for (int i = 0; i < carNum; i++) {
            int position = collection.getCarPosition(i);
            int expectedPosition = (carIdx == i) ? movedPosition : unMovedPosition;
            executables[i] = () -> {
                assertThat(position)
                        .isEqualTo(expectedPosition);
            };
        }
        Assertions.assertAll(executables);
    }
}
