package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class CarGroupTest {

    @ParameterizedTest
    @DisplayName("입력받은 자동차 대수 getCarNum 값이 같아야 한다.")
    @ValueSource(strings = {"1", "2,2", "3,3,3", "4,4,4,4", "5,5,5,5,5", "6,6,6,6,6,6", "7,7,7,7,7,7,7"})
    void getCarNum(String carCsv) {
        int carNum = carCsv.split(RegexConst.NAME_SPLIT).length;
        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);
        CarGroup cars = new CarGroup(carCsv, strategy);
        assertThat(cars.getCarNum())
                .isEqualTo(carNum);
    }

    @ParameterizedTest
    @DisplayName("carIndex 의 car 만 전진해야 한다.")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void moveCar(int carIdx) {
        String carCsv = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10";
        int carNum = carCsv.length();
        MoveStrategy strategy = new MoveStrategy() {
            @Override
            public boolean checkMovable() {
                return true;
            }
        };

        CarGroup cars = new CarGroup(carCsv, strategy);
        cars.moveCar(carIdx);

        int unMovedPosition = 1;
        int movedPosition = 2;

        Executable[] executables = new Executable[carNum];
        for (int i = 0; i < carNum; i++) {
            int position = cars.getCarPosition(i);
            int expectedPosition = (carIdx == i) ? movedPosition : unMovedPosition;
            executables[i] = () -> {
                assertThat(position)
                        .isEqualTo(expectedPosition);
            };
        }
        Assertions.assertAll(executables);
    }
}
