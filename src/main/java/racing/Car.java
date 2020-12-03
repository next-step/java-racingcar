package racing;

public class Car {
    private static final char sign = '-';
    private int allMeter = 0;
    private Display display;

    public Car(Display display) {
        this.display = display;
    }

    public int run(int inputNumber) {
        allMeter = allMeter + returnMeterByCondition(inputNumber);
        for (int i = 0; i < allMeter; i++) {
            display.print(sign);
        }
        stopRunning();
        return allMeter;
    }
    protected int returnMeterByCondition(int inputNumber){
        int moveableNumber = 4;
        if (inputNumber < moveableNumber) {
            return 0;
        }
        return inputNumber;
    }

    private void stopRunning() {
        display.printEmptyLine();
    }

    public int totalMeter() {
        return this.allMeter;
    }
}
