package RacingGame.Domain;

import RacingGame.View.InputView;
import RacingGame.View.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private int move = 0;

    public void MoveForward(int rval) {
        if (rval > 4) move++;
    }

    public int GetMoveInfo() {
        return move;
    }
}
