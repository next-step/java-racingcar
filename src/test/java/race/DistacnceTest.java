package race;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import race.util.Distance;

class DistacnceTest {

    @DisplayName("움직인 거리가 0이면 아무것도 출력하지 않는다.")
    @Test
    void test1() throws Exception {
        String result = Distance.get(0);

        assertThat(result).isEmpty();
    }

    @DisplayName("움직인 거리가 1이상 이면 1을 출력한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void test2(int input){
        String result = Distance.get(input);

        assertThat(result).hasSize(input);
    }
}
