package racingcar;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingUtilTest {

    @Test
    public void 우승자_이름_콤마로_묶기() {
        String result = RacingUtil.getJoiningName(Arrays.asList(new Car("sy"), new Car("dh")));
        assertThat(result).isEqualTo("sy,dh");

    }
}
