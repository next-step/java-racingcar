package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.CarFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @DisplayName("자동차 이름 리스트로 자동차를 만들어주는지 테스트")
    @Test
    public void createByNames() {
        List<String> carNames = Arrays.asList("henrry", "hyeonix", "javajigi");
        assertThat(CarFactory.createCarsByNames(carNames).size()).isEqualTo(3);
    }
}
