package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceWinnerFinderTest {

    RaceWinnerFinder raceWinnerFinder;

    Car nio;
    Car hoon;
    Car mit;
    Car bill;

    MoveCondition alwaysMatch = () -> true;

    @BeforeEach
    void setUp(){
        this.raceWinnerFinder = new RaceWinnerFinder();
        nio = new Car("nio");
        hoon = new Car("hoon");
        mit = new Car("mit");
        bill = new Car("bill");
    }

    @Test
    @DisplayName("가장많이 이동한 차가 최종 우승합니다")
    void raceWinner(){
        nio.moveIf( alwaysMatch );
        nio.moveIf( alwaysMatch );
        nio.moveIf( alwaysMatch );
        nio.moveIf( alwaysMatch );

        hoon.moveIf( alwaysMatch );

        mit.moveIf( alwaysMatch );
        mit.moveIf( alwaysMatch );
        mit.moveIf( alwaysMatch );

        bill.moveIf( alwaysMatch );
        bill.moveIf( alwaysMatch );

        List<Car> winners = raceWinnerFinder.find(Arrays.asList(nio, hoon, mit, bill));

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).contains(nio);
        assertThat(winners).doesNotContain(hoon, mit, bill);
    }

    @Test
    @DisplayName("가장많이 이동한 차가 한대이상이면 공동우승합니다.")
    void raceWinners(){
        nio.moveIf( alwaysMatch );
        nio.moveIf( alwaysMatch );
        nio.moveIf( alwaysMatch );
        nio.moveIf( alwaysMatch );

        hoon.moveIf( alwaysMatch );
        hoon.moveIf( alwaysMatch );
        hoon.moveIf( alwaysMatch );
        hoon.moveIf( alwaysMatch );

        mit.moveIf( alwaysMatch );
        mit.moveIf( alwaysMatch );
        mit.moveIf( alwaysMatch );

        bill.moveIf( alwaysMatch );
        bill.moveIf( alwaysMatch );

        List<Car> winners = raceWinnerFinder.find(Arrays.asList(nio, hoon, mit, bill));

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains(nio, hoon);
        assertThat(winners).doesNotContain(mit, bill);

    }

}