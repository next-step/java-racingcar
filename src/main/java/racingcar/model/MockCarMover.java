package racingcar.model;

import java.util.List;

import static racingcar.model.RandomCarMover.MOVING_CONDITION;
import static racingcar.model.RandomCarMover.RANDOM_LIMIT;

class MockCarMover extends CarMover {

    private int index;
    private List<Integer> mock;

    public MockCarMover(List<Integer> mock) {
        mock.stream().forEach(integer -> validateState(integer));
        this.mock = mock;
    }

    private void validateState(int state) {
        if(state < 0 || state >= RANDOM_LIMIT) {
            throw new IllegalArgumentException("STATE 입력값이 잘못되었습니다.");
        }
    }

    @Override
    protected boolean isMove() {
        return MOVING_CONDITION <= mock.get(index++);
    }
}