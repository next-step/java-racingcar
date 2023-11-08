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
        final Car bobo = new Car("bobo", () -> true);
        final Car coco = new Car("coco", () -> true);
        final Car nono = new Car("nono", () -> false);
        final Cars cars = new Cars(Arrays.asList(bobo, coco, nono));

        //when
        cars.move();
        List<String> winnerList = cars.findWinner();

        //then
        assertThat(winnerList).contains("bobo");
        assertThat(winnerList).contains("coco");
    }
}
