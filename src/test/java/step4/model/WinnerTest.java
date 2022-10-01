package step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.util.FixedNumberGenerator;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    Cars cars;
    Winners winners;

    @BeforeEach
    void beforeEach(){
        cars = new Cars();
        winners = new Winners();
        cars.init("hi,hy,hu,ho");
        IntStream.range(0, 2).forEachOrdered(i -> cars.getCars().get(i).move(new FixedNumberGenerator().generate(5)));
    }

    @Test
    @DisplayName("우승자의 기준을 잘 가져오는지에 대한 확인")
    void getWinnerStandardTest(){
        assertThat(winners.getWinnerStandard(cars)).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 목록을 예상대로 잘 가져오는지에 대한 확인")
    void getWinnerTest(){
        winners.checkWinners(cars, 1);
        assertThat(winners.getWinners()).isEqualTo("hi, hy");
    }
}
