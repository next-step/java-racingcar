package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {

    @DisplayName("입력된 자동차 플레이어만큼 Cars가 만들어진다")
    @Test
    public void should_make_cars() throws Exception {
        //arrange
        List<Player> players = Arrays.asList(
                new Player("aaa"),
                new Player("bbbb"),
                new Player("ccccc"));

        //act
        Cars cars = new Cars(new Players(players));

        //assert
        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}