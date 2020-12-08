package racing;

public class Car {
//    private Display display;
    private int allMeter = 0;
    private String name;

    public Car( String name){
        this.name = name;
    }

    public int run( int randomNumber) {
        allMeter = allMeter + returnMeterByCondition(randomNumber);
        return allMeter;
    }

    protected int returnMeterByCondition(int inputNumber){
        int moveableNumber = 4;
        if (inputNumber < moveableNumber) {
            return 0;
        }
        return  1;
    }

    public String getName(){
        return this.name;
    }
    public int totalMeter() {
        return this.allMeter;
    }

}
