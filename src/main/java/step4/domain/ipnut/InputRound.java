package step4.domain.ipnut;

public final class InputRound {

    private final int round;

    public InputRound(int round) {
        if(round < 0) {
            throw new IllegalArgumentException("유효하지 않은 값을 사용했습니다.");
        }
        this.round = round;
    }

}
