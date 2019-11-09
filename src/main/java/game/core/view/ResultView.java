package game.core.view;

import game.core.domain.ResultEntity;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public interface ResultView<T> {
    void render(ResultEntity<T> entity);
}
