package racing.domain;

public class RandomNumMovableStrategy implements MovableStrategy {

    private final NumberProvider numberProvider;

    public RandomNumMovableStrategy(NumberProvider numberProvider) {
        this.numberProvider = numberProvider;
    }

    @Override
    public boolean canMove() {
        int num =  numberProvider.getNumber();
        if(num < 0 || num > 9){
            throw new IllegalArgumentException("0~9사이의 숫자만 입력 가능");
        }
        return num >= 4;
    }

}
