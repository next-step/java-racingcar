package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.AnnouncementPrinter;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("carName 이 MAX_CAR_NAME_LENGTH 초과면 에러가 발생한다")
    void createWithTooLongName() {
        //given
        char[] array = new char[Car.MAX_CAR_NAME_LENGTH + 1];
        Arrays.fill(array, 'a');
        String carName = new String(array);

        //then
        assertThatThrownBy(() -> CarName.create(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AnnouncementPrinter.CAR_NAME_INVALID_ANNOUNCEMENT);
    }
}