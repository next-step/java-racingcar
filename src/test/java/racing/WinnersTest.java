package racing;

import org.junit.jupiter.api.Test;
import racing.strategy.DefaultMoveStategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    public void 우승자찾기() {

        String[] inputs = Stream.<String>builder()
                                .add("경현")
                                .add("에디")
                                .add("슈마허")
                                .build()
                                .toArray(String[]::new);

        ArrayList<String> excpected = Stream.<String>builder()
                .add("경현")
                .add("에디")
                .add("슈마허")
                .build()
                .collect(toCollection(ArrayList<String>::new));

        RacingCars cars = RacingCars.of(inputs);
        cars.startRacing(3, new DefaultMoveStategy());

        assertThat(Winners.getWinner(cars)).isEqualTo(excpected);
    }
}
