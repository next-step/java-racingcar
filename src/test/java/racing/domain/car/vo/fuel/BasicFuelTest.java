package racing.domain.car.vo.fuel;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BasicFuelTest {
    @ValueSource(ints = {
            0, 9
    })
    @ParameterizedTest
    public void ctorTest(int fuelValue) {
        new BasicFuel(fuelValue);
    }

    @ValueSource(ints = {
            -1, -2, 10, 11
    })
    @ParameterizedTest
    public void ctorIllegalArgumentExceptionTest(int fuelValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->
                        new BasicFuel(fuelValue)
                );
    }

    @CsvSource({
            "1000,0,false",
            "1000,3,false",
            "1000,4,true",
            "1000,9,true"
    })
    @ParameterizedTest
    public void isMovableTest(int testSize, int fuelValue, boolean result) {
        Set<Boolean> values = new HashSet<>();
        values.add(new BasicFuel(fuelValue).isMovable());

        assertThat(values.size())
                .withFailMessage("여러번 호출의 결과가 동일하지 않습니다.")
                .isEqualTo(1);

        assertThat(values.iterator().next())
                .withFailMessage("예상한 결과가 다릅니다.")
                .isEqualTo(result);
    }
}