package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarCollectionTest {
    @Test
    @DisplayName("지정한 car의 개수를 반환할 수 있다.")
    void size() {
        CarCollection carCollection = new CarCollection(5);
        assertThat(carCollection.size()).isEqualTo(5);
    }
}
