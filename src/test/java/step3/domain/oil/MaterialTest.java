package step3.domain.oil;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MaterialTest {

    @DisplayName("요청 받은 개수에 따라 잘 생성되는지")
    @ParameterizedTest
    @ValueSource(longs = {13, 12, 1})
    void createTest(Long materialCount) throws Exception {
        List<Material> materials = Material.createRandoms(materialCount);
        assertThat(Long.valueOf(materials.size())).isEqualTo(materialCount);
    }

}
