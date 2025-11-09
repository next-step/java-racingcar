package racingGame.model;

public class RacingGameRules {
    
    private int moves;
    private int cars;
    
    public RacingGameRules() {
    }
    
    private RacingGameRules(int moves, int cars) {
        this.moves = moves;
        this.cars = cars;
    }
    
    public static RacingGameRules of(int moves, int cars) {
        validate(moves, cars);
        return new RacingGameRules(moves, cars);
    }
    
    private static void validate(int moves, int cars) {
        validateCar(cars);
        validateMove(moves);
    }
    
    private static void validateCar(int cars){
        if(cars < 1) {
            throw new IllegalArgumentException("참가시킬 자동차 수 입력이 생략되거나, 0이하");
        }
    }
    
    private static void validateMove(int moves) {
        if(moves < 1) {
            throw new IllegalArgumentException("이동횟수에 입력이 생략되거나, 0이하");
        }
    }
    
    public RacingGameRules getRules() {
        return this;
    }
}
