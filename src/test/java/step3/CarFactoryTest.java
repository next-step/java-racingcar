package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.factory.CarFactory;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동자 공장 테스트")
public class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    @DisplayName("자동자 단일생성")
    public void create(String name) {
        assertThat(CarFactory.create(name).getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동자 생성")
    public void creates() {
        String[] names = { "pobi", "crong", "honux" };
        assertThat(CarFactory.creates(names)).hasSize(names.length);
    }

}
