public class Car {
    private int numberOfAdvance = 0;

    public int getNumberOfAdvance(){
        return this.numberOfAdvance;
    }

    /**
     * 들어온 전략을 실행하여 나온 수가 4 이상인 경우 전진상태 숫자 증가.
     * @param condition
     */
    public void advance(GameCondition condition) {
        if (condition.moveCondition() >= 4) {
            numberOfAdvance++;
        }
    }
}
