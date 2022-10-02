package racing.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:3", "3:4","4:5", "5:6"}, delimiter = ':')
    void increase_호출시_값이_증가_하는지_테스트(int before, int after)
    {
        //given
        Position position = Position.of(before);
        //when
        position.increase();
        //then
        assertThat(position.getPosition()).isEqualTo(after);
    }
}