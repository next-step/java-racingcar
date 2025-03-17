import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("자동차 메소드 테스트")
class CarTest {

    @InjectMocks
    private Car car;

    @DisplayName("숫자가 4보다 같거나 크면 앞으로 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void move_greater_equal_four(int input) {

        try (MockedStatic<RandomUtil> mockedStatic = mockStatic(RandomUtil.class)) {
            //given
            when(RandomUtil.nextInt(10)).thenReturn(input);

            //when
            car.move();

            //then
            assertThat(car.getPosition()).isEqualTo(1);
        }

    }

    @DisplayName("숫자가 4보다 작으면 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void move_less_four(int input) {

        try (MockedStatic<RandomUtil> mockedStatic = mockStatic(RandomUtil.class)) {
            //given
            when(RandomUtil.nextInt(10)).thenReturn(input);

            //when
            car.move();

            //then
            assertThat(car.getPosition()).isEqualTo(0);
        }

    }

}