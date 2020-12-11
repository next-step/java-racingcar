package racing.domain;

public class Car implements Comparable<Car> {
    private int allMeter = 0;
    private String name;

    public Car(String name){
        this.name = name;
    }
    public Car(String name, int totalMeter) {
        this.name = name;
        this.allMeter = totalMeter;
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

    public int compareMeter(Car carB) {
        if( this.totalMeter() > carB.totalMeter()){
              return 1;
        }
        if( this.totalMeter() < carB.totalMeter()){
            return -1;
        }
        return 0;

    }

    @Override
    public int compareTo(Car otherCar) {
        if( this.totalMeter() > otherCar.totalMeter()){
            return 1;
        }
        if( this.totalMeter() < otherCar.totalMeter()){
            return -1;
        }
        return 0;
    }
}
