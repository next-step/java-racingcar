package step3.domain;

public class Car {

    private final int goCondition = 4;

    private int goCount;

    public void go(int randomValue){
        if(randomValue >= goCondition){
            goCount++;
        }
    }
    public int getGoCount() {
        return goCount;
    }
}
