package race;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarNameFactoryTest {
    @Test
    void 쉼표로_구분된_문자열로부터_carName_여러개를_만들_수_있다() {
        List<CarName> carNameList = CarNameFactory.makeCarNames("a,b,c");
        assertThat(carNameList.toArray()).contains("a", "b", "c");
    }
}
