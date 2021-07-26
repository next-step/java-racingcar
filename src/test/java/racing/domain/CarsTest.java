package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.utils.RandomNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @DisplayName("입력된 자동차 플레이어 중 1개만 움직이고 나머지는 움직이지 못했다면 우승Car는 1개이다.")
    @Test
    public void should_select_winner() throws Exception {
        //arrange
        List<Player> players = Arrays.asList(
                new Player("aaa"),
                new Player("bbbb"),
                new Player("ccccc"));
        Cars cars = new Cars(new Players(players));
        Set<String> expectedWinners = new HashSet<String>(){{
            add("aaa");
        }};

        //act
        cars.race(new TestingRandomMovingStrategy(new RandomNumber()));

        //assert
        assertThat(cars.getWinnerCarsName()).isEqualTo(expectedWinners);
    }

    private static class TestingRandomMovingStrategy extends RandomMovingStrategy {

        private boolean isMovable = true;

        public TestingRandomMovingStrategy(RandomNumber randomNumber) {
            super(randomNumber);
        }

        @Override
        public boolean isMove() {
            if (isMovable) {
                isMovable = false;
                return true;
            }
            else {
                return false;
            }
        }

    }

}