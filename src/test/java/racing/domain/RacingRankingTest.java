package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class RacingRankingTest {

    private RacingGame game = null;
    private RacingRanking ranking = null;
    private String[] winners = null;
    private Map<String, Integer> mockCars = null;
    private int mockTimes = 3;
    
    @Before
    public void setup() {
        mockCars = new HashMap<>();
    } 

    @Test
    public void 레이싱경기_1명_우승자_확인() {
        game = makeRacingGame(testSetWinner1AndLoser1(), true);
        ranking = new RacingRanking(game);
        winners = ranking.getWinners();

        assertThat(Arrays.toString(winners)).isEqualTo("[winner]");
    }

    @Test
    public void 레이싱경기_2명_우승자_확인() {
        game = makeRacingGame(testSetWinner2AndLoser1(), true);
        ranking = new RacingRanking(game);
        winners = ranking.getWinners();

        assertThat(Arrays.toString(winners)).isEqualTo("[winner1, winner2]");
    }

    @Test
    public void 레이싱경기_진행중일때_확인() {
        game = makeRacingGame(testSetWinner1AndLoser1(), false);
        ranking = new RacingRanking(game);
        
        try {
            winners = ranking.getWinners();
            fail("RacingGame's still playing...");
        } catch (RacingGameException e) {}

    }

    private Map<String, Integer>  testSetWinner2AndLoser1() {
        mockCars.put("winner1", 2);
        mockCars.put("winner2", 2);
        mockCars.put("loser", 1);
        return mockCars;
    }
    
    private Map<String, Integer> testSetWinner1AndLoser1() {
        mockCars.put("winner", 2);
        mockCars.put("loser", 1);
        return mockCars;
    }
    
    private RacingGame makeRacingGame(Map<String, Integer> mockCars, boolean isFinish) {
        return new RacingGame(mockTimes, getCarName(mockCars)) {
            @Override
            public boolean isFinish() {
                return isFinish;
            }
            
            @Override
            public List<RacingCar> getResultOfTheGame() {
                return convertToRacingCar(mockCars);
            }
        };
    }

    private List<RacingCar> convertToRacingCar(Map<String, Integer> mockCars) {
        return mockCars.entrySet().stream().map(entry -> new RacingCar(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }
    
    private String[] getCarName(Map<String, Integer> mockCars) {
        return mockCars.keySet().toArray(new String[mockCars.size()]);
    }
}