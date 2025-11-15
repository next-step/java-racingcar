package racingGame.model;

public record NonNegativeMoves(int moves) {
    
    public NonNegativeMoves {
        validate(moves);
    }
    
    private void validate(int moves) {
        if(moves < 1) {
            throw new IllegalArgumentException("이동횟수에 입력이 생략되거나, 0이하");
        }
    }
}
