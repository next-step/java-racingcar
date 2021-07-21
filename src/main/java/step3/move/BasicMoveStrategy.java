package step3.move;

import step3.App;

public class BasicMoveStrategy implements MovableStrategy{
    @Override
    public int move(int num) {
        return num >= App.CRITERION_NUMBER ? 1 : 0;
    }
}
