package step3;

public class Limit {

    private LimitStrategy limitStrategy;

    public int getLimit() {
        return limitStrategy.getLimit();
    }

    public void setLimitStrategy(LimitStrategy limitStrategy) {
        this.limitStrategy = limitStrategy;
    }
}
