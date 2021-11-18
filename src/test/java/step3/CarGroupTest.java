package step3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGroupTest {

    @Test
    void 자동차그룹_쉼표_생성() {
        assertThat(new CarGroup("nell,dklee,good")).isEqualTo(new CarGroup("nell,dklee,good"));
    }

    @Test
    void 자동차그룹_앞뒤_공백포함_쉼표_생성() {
        assertThat(new CarGroup("nell,dklee")).isEqualTo(new CarGroup("nell,dklee  "));
        assertThat(new CarGroup("nell, dklee")).isEqualTo(new CarGroup("nell,dklee "));
    }

    @Test
    void 자동차그룹_우승자_이름찾기() {
        List<Car> cars = Arrays.asList(new Car("nell", 3), new Car("dk", 2), new Car("lee", 3));
        assertThat(new CarGroup(cars).getFarthestCarNames()).isEqualTo(Arrays.asList("nell","lee"));
        cars = Arrays.asList(new Car("nell", 3), new Car("dk", 4), new Car("lee", 3));
        assertThat(new CarGroup(cars).getFarthestCarNames()).isEqualTo(Arrays.asList("dk"));
    }
}
