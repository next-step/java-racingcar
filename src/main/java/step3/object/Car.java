package step3.object;

public class Car {

    final int goCondition = 4;

    int goCount;

    public void go(int randomValue){
        if(randomValue >= goCondition){
            goCount++;
        }
    }
    public int getGoCount() {
        return goCount;
    }
}
