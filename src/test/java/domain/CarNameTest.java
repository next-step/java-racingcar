package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    private static final String SPLIT_COMMA = ",";

    @Test
    void 자동차_이름_생성() {
        CarName carName = new CarName("hong");
        assertThat(carName).isEqualTo(new CarName("hong"));
    }

    @Test
    void 자동차_이름_5글자_초과_생성() {
        assertThatThrownBy(() -> new CarName("hong car"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 자동차_이름_null_또는_공백_생성() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalStateException.class);

        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b"})
    void 자동차_이름은_쉼표_기준으로_생성한다(int input, String expected) {
        CarName carName = new CarName("a,b");
        List<CarName> carNameList = Arrays.stream(carName.getCarName()
                .split(SPLIT_COMMA))
                .map(CarName::new)
                .collect(Collectors.toList());

        assertThat(carNameList).hasSize(2);
        assertThat(carNameList.get(input)).isEqualTo(new CarName(expected));
    }
}