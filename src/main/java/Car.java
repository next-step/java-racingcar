import java.util.Random;

public class Car {
    private int location;
    private final ResultView resultView = new ResultView();

    public Car(int location) {
        this.location = location;
    }

    public void printLocation() {
        resultView.printCarLocation(this);
    }

    public boolean randomGo() {
        if (getRandomInt() >= 4) {
            go();
            return true;
        }
        stop();
        return false;
    }

    private int getRandomInt() {
        return new Random().nextInt(10);
    }

    public void go() {
        this.location++;
    }

    public void stop() {
    }

    public int getLocation() {
        return this.location;
    }
}
