package racingGame.model;

public record NonNegativeReadyCars(String[] names) {
    
    public NonNegativeReadyCars {
        validateCar(names.length);
    }
    
    private static void validateCar(int cars) {
        if(cars < 1) {
            throw new IllegalArgumentException("참가시킬 자동차 수 입력이 생략되거나, 0이하");
        }
    }
}
