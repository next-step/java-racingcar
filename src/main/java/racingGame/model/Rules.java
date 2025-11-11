package racingGame.model;

public class Rules {
    
    private int moves;
    
    public Rules() {
    }
    
    public Rules(int moves) {
        validate(moves);
        this.moves = moves;
    }
    
    public boolean isLimitMove(int currentMoves) {
        return this.moves > currentMoves;
    }
    
    private static void validate(int moves) {
        validateMove(moves);
    }

    private static void validateMove(int moves) {
        if(moves < 1) {
            throw new IllegalArgumentException("이동횟수에 입력이 생략되거나, 0이하");
        }
    }
    
}
