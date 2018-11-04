package racing.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingRankingTest {

    private RacingGame game = null;
    private RacingRanking ranking = null;
    private String[] winners = null;

    @Test
    public void 레이싱경기_1명_우승자_확인() {
        game = makeRacingGame(new String[] {"winner", "looser"}, new ArrayList(){
            {add(makeRacingCar("winner", 2));}
            {add(makeRacingCar("looser", 1));}
        }, true);

        ranking = new RacingRanking(game);
        winners = ranking.getWinners();

        assertThat(Arrays.toString(winners)).isEqualTo("[winner]");
    }

    @Test
    public void 레이싱경기_2명_우승자_확인() {
        game = makeRacingGame(new String[] {"winner1", "winner2", "looser"}, new ArrayList(){
            {add(makeRacingCar("winner1", 2));}
            {add(makeRacingCar("winner2", 2));}
            {add(makeRacingCar("looser", 1));}
        }, true);

        ranking = new RacingRanking(game);
        winners = ranking.getWinners();

        assertThat(Arrays.toString(winners)).isEqualTo("[winner1, winner2]");
    }

    @Test
    public void 레이싱경기_진행중일때_확인() {
        game = makeRacingGame(new String[] {"winner", "looser"}, new ArrayList(){
            {add(makeRacingCar("winner", 2));}
            {add(makeRacingCar("looser", 1));}
        }, false);

        ranking = new RacingRanking(game);
        try {
            winners = ranking.getWinners();
            fail("RacingGame's still playing...");
        } catch (RacingGameException e) {}

    }

    private RacingGame makeRacingGame(String[] names, List<RacingCar> cars, boolean isFinish) {
        return new RacingGame(3, names) {
            @Override
            public boolean isFinish() {
                return isFinish;
            }

            @Override
            public List<RacingCar> getResultOfTheGame() {
                return cars;
            }
        };
    }

    private RacingCar makeRacingCar(String name, int position) {
        return new RacingCar(name) {
            @Override
            public int getCurrentPosition() {
                return position;
            }
        };
    }
}