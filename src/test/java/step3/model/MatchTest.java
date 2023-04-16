package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.present.DisplayRaceVO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MatchTest {
    @DisplayName("참가차랑수, 반복횟수에 맞게 결과를 생성한다")
    @Test
    public void matchTest() {
        //given
        List<Car> participates = Stream.of("a", "b", "c", "d", "e")
            .map(Car::new)
            .collect(Collectors.toList());
        int iterations = 7;
        //when
        List<DisplayRaceVO> display = new Match(participates, iterations).display();
        //then
        assertAll(
            () -> assertThat(display).hasSize(participates.size()),
            () -> assertThat(display.get(0).getResult().getPositionList()).hasSize(iterations)
        );
    }

    @DisplayName("우승자의 이름이 출력된다")
    @Test
    public void winnerDisplayTest() {
        //given
        String input = "pobi";
        int iterations = 3;
        //when
        List<String> strings = new Match(
            Stream.of(input)
                .map(Car::new)
                .collect(Collectors.toList()),
            iterations).winnerDisplay();
        //then
        assertThat(String.join(",", strings)).contains(input);
    }
}