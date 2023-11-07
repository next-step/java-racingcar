package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2", "3:4", "5:6"}, delimiter = ':')
    public void processTest(int carNumber, int tryCount) {
        ServiceLogic serviceLogic = new ServiceLogic();
        serviceLogic.process(carNumber, tryCount);

        assertThat(serviceLogic.getResultMap().size()).isEqualTo(carNumber);

        serviceLogic.getResultMap().forEach((integer, strings) -> {
            assertThat(strings.size()).isLessThanOrEqualTo(tryCount);
        });

    }

}