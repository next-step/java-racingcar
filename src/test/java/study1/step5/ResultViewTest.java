package study1.step5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    void carResultTest(){
        Car car = new Car("test racer", 5);
        assertThat(ResultView.getCarResult(car)).isEqualTo("-----");
    }

    @Test
    void WinnerListToStringTest(){
        ArrayList<String> winnerListAnswer = new ArrayList<>();
        winnerListAnswer.add("first");
        winnerListAnswer.add("second");
        winnerListAnswer.add("third");

        assertThat(ResultView.toStringRacerList(winnerListAnswer)).isEqualTo("first, second, third");
    }
}
