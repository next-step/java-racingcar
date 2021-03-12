package step3;

public class Limit4Strategy implements LimitStrategy {

    @Override
    public int getLimit() {
        return CarConstant.FOUR;
    }
}
