package game;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    public void 리스트를넘기면_공동우승자반환() {
        List<Car> cars = Arrays.asList(new Car(3,"A"),new Car(3,"B"),new Car(1,"C"));

        String anwser = "A, B";
        String winner = Winners.findWinners(cars);

        assertThat(winner).isEqualTo(anwser);
    }

    @Test
    public void 리스트를넘기면_단우승자반환() {
        List<Car> cars = Arrays.asList(new Car(4,"A"),new Car(3,"B"),new Car(1,"C"));

        String anwser = "A";
        String winner = Winners.findWinners(cars);

        assertThat(winner).isEqualTo(anwser);
    }
}