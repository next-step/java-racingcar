package racing.domain;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SelectingWinnerCarsTest {

    @DisplayName("입력된 자동차 플레이어만큼 Cars가 만들어진다")
    @Test
    public void should_select_winner_cars() throws Exception {
        //arrange
        WinnerCarsSelector winnerCarsSelector = makeCarWinners();
        Set<String> expectedWinners = new HashSet<String>(){{
            add("car3");
        }};

        //act
        Set<String> winners = winnerCarsSelector.selectWinnersName();

        //assert
        assertThat(winners).isEqualTo(expectedWinners);
    }

    @NotNull
    private WinnerCarsSelector makeCarWinners() {
        CarPosition carPosition1 = new CarPosition(1);
        carPosition1.save();
        CarPosition carPosition2 = new CarPosition(2);
        carPosition2.save();
        CarPosition carPosition3 = new CarPosition(3);
        carPosition3.save();

        Car car1 = new Car(new Player("car1"), carPosition1);
        Car car2 = new Car(new Player("car2"), carPosition2);
        Car car3 = new Car(new Player("car3"), carPosition3);

        return new WinnerCarsSelector(Arrays.asList(car1, car2, car3));
    }

}