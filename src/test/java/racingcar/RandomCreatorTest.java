package racingcar;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import racingcar.domain.RandomCreator;

public class RandomCreatorTest {

    @Test
    public void 랜덤값_테스트() {
        int newPosition = RandomCreator.createNewPosition();
        assertThat(newPosition).isBetween(0,9);
    }
}
