package step3;

public class Car {

    int goCount;

    public Car() {
        this.goCount = 0;
    }

    public int getGoCount() {
        return goCount;
    }

    public void addGoCount() {
        this.goCount += 1;
    }

    public void goOrStop(boolean goStop) {
        if(goStop){
            this.addGoCount();
        }
    }
}
