package racingcar.domain;

public class Cycle {
    private static final int ZERO = 0;
    private static final String INVALIDATE_ZERO_CYCLE_MESSAGE = "시도 횟수는 0으로 입력할 수 없습니다.";
    private static final String INVALIDATE_MINUS_CYCLE_MESSAGE = "시도 횟수는 음수로 입력할 수 없습니다.";

    private int cycle;

    public Cycle(int cycle) {
        invalidateCycle(cycle);
        this.cycle = cycle;
    }

    private void invalidateCycle(int cycle){
        if(cycle == ZERO){
            throw new IllegalArgumentException(INVALIDATE_ZERO_CYCLE_MESSAGE);
        }
        if(cycle < ZERO){
            throw new IllegalArgumentException(INVALIDATE_MINUS_CYCLE_MESSAGE);
        }
    }

    public void minus() {
        this.cycle--;
    }

    public boolean isPlaying() {
        return this.cycle == 0;
    }
}
