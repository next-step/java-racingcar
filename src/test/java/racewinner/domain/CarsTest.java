package racewinner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("가장 높은 step의 자동차들이 리턴된다.")
    @Test
    void winnerTest() {
        //given
        final Car bobo = new Car("bobo", new Position(3),  null);
        final Car coco = new Car("coco", new Position(3), null);
        final Car nono = new Car("nono", new Position(1), null);
        final Cars cars = new Cars(Arrays.asList(bobo, coco, nono));

        //when
        List<String> winnerList = cars.findWinner();

        //then
        assertThat(winnerList.size()).isEqualTo(2);
        assertThat(winnerList).contains("bobo");
        assertThat(winnerList).contains("coco");
    }
}
