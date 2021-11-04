package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OilTest {

    @DisplayName("좋은기름은 재료품질이 4이상일 때 나온다.")
    @ParameterizedTest(name = "[{index}] 품질이 {0} 인 재료는 {1} 기름을 만든다.")
    @CsvSource(value = {
            "LOW_QUALITY, BAD",
            "HIGH_QUALITY, GOOD",
            "HIGH_QUALITY, GOOD",
    })
    void createOil(Material material, Oil expectedOil) throws Exception {
        Oil producedOil = Oil.create(material);
        assertThat(producedOil).isEqualTo(expectedOil);
    }

    @DisplayName("기름의 상태에 따라 출력 상태가 다르다.")
    @ParameterizedTest(name = "[{index}] {0} 기름은 {1} 출력을 만든다")
    @CsvSource(value = {
            "GOOD, SUFFICIENT",
            "BAD, INSUFFICIENT",
    })
    void burnOilTest(Oil oil, Power expectedPower) {
        assertThat(oil.burn()).isEqualTo(expectedPower);
    }
}
