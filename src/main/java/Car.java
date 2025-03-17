public class Car {
    private int location;
    private final ResultView resultView = new ResultView();

    public Car(int location) {
        this.location = location;
    }

    public void printLocation() {
        resultView.printCarLocation(this);
    }

    public void randomGo(int randomValue) {
        if (randomValue >= 4)
            go();
    }

    public void go() {
        this.location++;
    }

    public int getLocation() {
        return this.location;
    }
}
