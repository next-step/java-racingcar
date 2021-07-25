package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {

    @DisplayName("Car가 움직인 만큼 기록하여 반환한다")
    @Test
    public void should_return_record_position() throws Exception {
        //arrange
        CarPosition carPosition = new CarPosition();
        carPosition.movePosition();
        carPosition.save();
        carPosition.movePosition();
        carPosition.movePosition();
        carPosition.save();
        carPosition.movePosition();
        carPosition.save();

        //act
        int position = carPosition.getPositionRecord(1);

        //assert
        assertThat(position).isEqualTo(3);
    }

}