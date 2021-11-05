package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarCreatorTest {

    @Test
    @DisplayName("전달받은 size의 리스트를 생성하는지 확인")
    void sizeTest(){
        int size = 10;
        assertThat(CarCreator.create(size).size()).isEqualTo(size);
    }
}
