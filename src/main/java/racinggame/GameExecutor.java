package racinggame;

import racinggame.vo.MoveResult;

import java.util.List;

public interface GameExecutor {

    List<MoveResult> execute();
}
