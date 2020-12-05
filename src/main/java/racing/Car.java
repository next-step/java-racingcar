package racing;

public class Car {
    private int allMeter = 0;
    private Display display;

    public Car(Display display) {
        this.display = display;
    }

    public int run(int inputNumber) {
        allMeter = allMeter + returnMeterByCondition(inputNumber);
        for (int i = 0; i < allMeter; i++) {
            display.printMove();
        }
        stopRunning();
        return allMeter;
    }
    protected int returnMeterByCondition(int inputNumber){
        int moveableNumber = 4;
        if (inputNumber < moveableNumber) {
            return 0;
        }
        this.allMeter = this.allMeter + 1;
        return allMeter;
    }

    private void stopRunning() {
        display.printEmptyLine();
    }

    public int totalMeter() {
        return this.allMeter;
    }
}
