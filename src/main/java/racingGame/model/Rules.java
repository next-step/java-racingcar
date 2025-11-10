package racingGame.model;

public class Rules {
    
    private int cars;
    private int moves;
    
    public Rules() {
    }
    
    private Rules(int cars, int moves) {
        this.cars = cars;
        this.moves = moves;
    }
    
    public static Rules of(int cars, int moves) {
        validate(cars, moves);
        return new Rules(cars, moves);
    }
    
    public boolean isLimitMove(int currentMoves) {
        return this.moves > currentMoves;
    }
    
    public boolean isLimitCars(int currentCars) {
        return this.cars > currentCars;
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
    
}
