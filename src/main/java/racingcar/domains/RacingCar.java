package racingcar.domains;

import racingcar.exceptions.StringLengthOverException;
import racingcar.strategies.MoveStrategy;
import racingcar.utils.RandomNumberUtil;

public class RacingCar {

    private String name;
    private int moveCnt;

    public RacingCar(String name) {
        validateCarName(name);
        this.name = name;
        this.moveCnt = 0;
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throwStringLengthOverException();
        }
    }

    private void throwStringLengthOverException() {
        try {
            throw new StringLengthOverException("Car name is too long");
        } catch (StringLengthOverException e) {
            e.printStackTrace();
        }
    }

    public int move(MoveStrategy moveStrategy) {
        if (RandomNumberUtil.isMovable(moveStrategy)) {
            return ++moveCnt;
        }
        return moveCnt;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public String getName() {
        return name;
    }
}
