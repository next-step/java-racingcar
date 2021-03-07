public class Car {
    private int numberOfAdvance = 0;

    public int getNumberOfAdvance(){
        return this.numberOfAdvance;
    }

    public void advance() {
        int condition = GameCondition.randomNumber(10);
        if (GameCondition.isAdvance(condition)) {
            numberOfAdvance++;
        }
    }
}
