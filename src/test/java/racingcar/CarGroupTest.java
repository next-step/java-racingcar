package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarGroupTest {

    @ParameterizedTest
    @DisplayName("입력받은 자동차 대수 getCarNum 값이 같아야 한다.")
    @ValueSource(strings = {"1", "2,2", "3,3,3", "4,4,4,4", "5,5,5,5,5", "6,6,6,6,6,6", "7,7,7,7,7,7,7"})
    void getCarNum(String carCsv) {
        int carNum = carCsv.split(RegexConst.NAME_SPLIT).length;
        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);
        CarGroup carGroup = new CarGroup(carCsv, strategy);
        assertThat(carGroup.getCarNum())
                .isEqualTo(carNum);
    }

    @ParameterizedTest
    @DisplayName("carIdx 의 car 만 전진해야 한다.")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void moveCar(int carIdx) {
        String carCsv = "0,1,2,3,4,5,6,7,8,9";
        MoveStrategy strategy = new MoveStrategy() {
            @Override
            public boolean checkMovable() {
                return true;
            }
        };

        CarGroup carGroup = new CarGroup(carCsv, strategy);
        carGroup.moveCar(carIdx);

        int unMovedPosition = 1;
        int movedPosition = 2;

        int carNum = carGroup.getCarNum();
        int[] expectedPositions = new int[carNum];
        Arrays.fill(expectedPositions, unMovedPosition);
        expectedPositions[carIdx] = movedPosition;
        IntStream expectedStream = Arrays.stream(expectedPositions);
        Iterator expectedItr = expectedStream.iterator();


        // FIXME: 두 Stream 을 비교하는 더 효과적인 방법은 없을까?
        Stream<Executable> executables = carGroup.getCarStream().<Executable>map(car -> () -> {
            assertThat(car.getPosition())
                    .isEqualTo(expectedItr.next());
        });
        Assertions.assertAll(executables);
    }
}
