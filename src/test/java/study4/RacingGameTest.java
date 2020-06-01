package study4;

import game.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {

    @DisplayName("경기 이름 입력 기능 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"뽀로로,크롱,포비"})
    void testCarName(String input) {

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        InputRacingPlayer inputView = new InputRacingPlayer();

        assertEquals(3, inputView.getCarPlayer().size());
    }

    @DisplayName("최종 우승자 찾는 기능 테스트")
    @Test
    void testFindWinner() {

        List<Position> positionsPobi = Stream.<Position>builder()
                .add(new Position(0, 2))
                .add(new Position(1, 3))
                .add(new Position(2, 2))
                .build().collect(Collectors.toList());

        List<Position> positionsCrong = Stream.<Position>builder()
                .add(new Position(0, 1))
                .add(new Position(1, 0))
                .add(new Position(2, 3))
                .build().collect(Collectors.toList());

        List<Position> positionsHonux = Stream.<Position>builder()
                .add(new Position(0, 1))
                .add(new Position(1, 2))
                .add(new Position(2, 2))
                .build().collect(Collectors.toList());

        List<Car> cars =
                Stream.<Car>builder()
                        .add(new Car("pobi", 3, positionsPobi))
                        .add(new Car("crong", 3, positionsCrong))
                        .add(new Car("honux", 2, positionsHonux))
                        .build().collect(Collectors.toList());
        assertThat(RacingGame.create().findWinner(cars)).hasSize(2);
    }

}
