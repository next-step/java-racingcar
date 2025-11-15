package racingGame.model;

public class NonNegativeMoves {
    
    int moves;
    
    public NonNegativeMoves(int moves) {
        validate(moves);
        this.moves = moves;
    }
    
    private void validate(int moves) {
        if(moves < 1) {
            throw new IllegalArgumentException("이동횟수에 입력이 생략되거나, 0이하");
        }
    }
    
    public int getMoves() {
        return moves;
    }
}
