package carRace.domain.car;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

import carRace.error.ErrorMessage;
import carRace.error.exception.NotPositiveNumberException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoveDistanceTest {

    @ParameterizedTest
    @CsvSource(value = {"0:0","1:1", "2:2"}, delimiter = ':')
    @DisplayName("이동거리가 0보다 크거나 양수여야 한다")
    public void Move_Distance_Should_Positive_Number(int input, int expected) throws Exception{
        //given
        MoveDistance sutMoveDistance = new MoveDistance(input);

        //when
        //then
        assertThat(sutMoveDistance.getMoveDistance()).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동거리는 음수일수 없다")
    public void Move_Distance_Should_Not_Positive_Number() throws Exception{
        //given
        int input = -1;
        String expected = ErrorMessage.MOVE_DISTANCE_NOT_POSITIVE_NUMBER.getMessage();

        //then
        NotPositiveNumberException actualException = catchThrowableOfType(
            () -> new MoveDistance(input), NotPositiveNumberException.class);

        //then
        assertThat(actualException).hasMessageContaining(expected);
    }

    @Test
    @DisplayName("이동거리는 정렬될수 있어야 한다")
    public void Move_Distance_Can_Sort() throws Exception{
        //given
        MoveDistance lowDistance = new MoveDistance(1);
        MoveDistance middleDistance = new MoveDistance(2);
        MoveDistance highDistance = new MoveDistance(3);
        List<MoveDistance> moveDistances = Arrays.asList(highDistance, middleDistance, lowDistance);

        //when
        moveDistances.sort(MoveDistance::compareTo);

        //then
        assertThat(lowDistance).isEqualTo(moveDistances.get(0));
        assertThat(middleDistance).isEqualTo(moveDistances.get(1));
        assertThat(highDistance).isEqualTo(moveDistances.get(2));
    }
}
