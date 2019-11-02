package game.racing;

/**
 * Created by yusik on 2019/11/02.
 */
@FunctionalInterface
public interface MoveStrategy {
    boolean movable(int number, int threshold);
}
