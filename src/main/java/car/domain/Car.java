package car.domain;

import spark.utils.StringUtils;

public class Car {
    private static final int MOVABLE_MINIMUM_NUM = 3;
    private String name;
    private int movingCount;

    private Car(String name) {
        this.name = StringUtils.isEmpty(name) ? "undefined" : name;
        this.movingCount = 0;
    }

    public static Car getCarInstance(String name) {
        return new Car(name);
    }


    public void move(int randomValue) {
        if ( MOVABLE_MINIMUM_NUM < randomValue) {
            movingCount = movingCount+1;
        }
    }

    public String getName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public String toString() {
        StringBuffer carResult = new StringBuffer();
        carResult.append(name+" : ");

        int i = 0;
        while ( i < this.movingCount) {
            carResult.append("-");
            i ++;
        }
        carResult.append("\n");

        return carResult.toString();
    }
}
