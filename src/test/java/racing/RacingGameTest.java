package racing;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    public void 게임초기값확인() {
        RacingGame rg = new RacingGame(5, 3);
        assertThat(rg.getTime()).isEqualTo(5);
        assertThat(rg.getList().size()).isEqualTo(3);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void 컬렉션수정가능확인() {
        RacingGame rg = new RacingGame(5, 3);
        List<Car> cars = rg.getList();
        cars.add(new Car());
    }

    @Test
    public void 게임결과확인() {
        RacingGame rg = new RacingGame(5, 3);
        RacingGameResult rgr = rg.racingGameResult();

        assertThat(rgr.getTime()).isEqualTo(5);
        assertThat(rgr.getCars().size()).isEqualTo(3);
    }


}