package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.Accelerator;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceleratorTest {

    @DisplayName("가속 메소드 TEST")
    @ParameterizedTest
    @CsvSource(value = {"0:1:true",
                        "4:1:false"},
               delimiter = ':')
    void accelerate(int min, int max, boolean result) {
        Accelerator accelerator = Accelerator.ofCustomAccelerator(min, max);
        assertThat(accelerator.accelerate()).isEqualTo(result);
    }
}