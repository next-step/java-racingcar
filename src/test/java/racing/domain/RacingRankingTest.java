package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class RacingRankingTest {

    private RacingGame game = null;
    private RacingRanking ranking = null;
    private String[] winners = null;
    private List<RacingCar> mockCars = null;
    private int mockTimes = 3;
    
    @Before
    public void setup() {
        mockCars = new ArrayList<>();
    } 

    @Test
    public void 레이싱경기_1명_우승자_확인() {
        ranking = new RacingRanking(testSetWinner1AndLoser1());
        winners = ranking.getWinners();

        assertThat(Arrays.toString(winners)).isEqualTo("[winner]");
    }

    @Test
    public void 레이싱경기_2명_우승자_확인() {
        ranking = new RacingRanking(testSetWinner2AndLoser1());
        winners = ranking.getWinners();

        assertThat(Arrays.toString(winners)).isEqualTo("[winner1, winner2]");
    }

    private List<RacingCar>  testSetWinner2AndLoser1() {
        mockCars.add(new RacingCar("winner1", 2));
        mockCars.add(new RacingCar("winner2", 2));
        mockCars.add(new RacingCar("loser", 1));
        return mockCars;
    }
    
    private List<RacingCar> testSetWinner1AndLoser1() {
        mockCars.add(new RacingCar("winner", 2));
        mockCars.add(new RacingCar("loser", 1));
        return mockCars;
    }
}