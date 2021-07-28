package step3.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CarTest {

    @InjectMocks
    private Car car;

    @Mock
    Random random;

    @ParameterizedTest
    @DisplayName("0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상인 경우 전진한다")
    @ValueSource(ints = {4,7,9})
    void tryMove_Move(int randomValue) {
        //given
        given(random.nextInt(10)).willReturn(randomValue);

        //when
        car.tryMove();

        //then
        int actual = car.getMovedDistance();
        assertEquals(actual, 1);
    }

    @ParameterizedTest
    @DisplayName("0에서 9 사이에서 random 값을 구한 후 random 값이 4 미만인 경우 stay")
    @ValueSource(ints = {0,1,3})
    void tryMove_Stay(int randomValue) {
        //given
        given(random.nextInt(10)).willReturn(randomValue);

        //when
        car.tryMove();

        //then
        int actual = car.getMovedDistance();
        assertEquals(actual, 0);
    }
}
