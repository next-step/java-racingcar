package study.racingcar.strategy;

/**
 * Created by wyparks2@gmail.com on 2019-06-19
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class MaxPositionWinnerStrategy implements AwardsStrategy {
    @Override
    public boolean isWinner(int maxPosition, int carPosition) {
        return maxPosition == carPosition;
    }
}
