package game.gambling;

import game.ResultEntity;
import game.ResultView;

/**
 * Created by yusik on 2019/10/29.
 */
public class GamblingResultView implements ResultView<GamblingResult> {
    @Override
    public void render(ResultEntity<GamblingResult> entity) {
        entity.getResult().getWinners().forEach(System.out::println);
    }
}
