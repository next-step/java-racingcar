package racingGame.model;

public class NonNegativeReadyCars {
    
    String[] names;
    
    public NonNegativeReadyCars(String[] carNames) {
        validateCar(carNames.length);
        this.names = carNames;
    }
    
    private static void validateCar(int cars){
        if(cars < 1) {
            throw new IllegalArgumentException("참가시킬 자동차 수 입력이 생략되거나, 0이하");
        }
    }
    
    public String[] getNames() {
        return names;
    }
}
