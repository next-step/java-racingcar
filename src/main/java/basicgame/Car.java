package basicgame;

import util.StringUtil;

public class Car implements Vehicle {
    private final static int CONDITION_VALUE = 4;
    private final static int MAX_NAME_SIZE = 5;
    private int distance;
    private String name;


    private Car(String name, int distance) {
        if(StringUtil.isBlank(name)){
            throw new NullPointerException("자동차 이름은 null이나 빈공백은 불가능");
        }
        if(name.length() > MAX_NAME_SIZE){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다");
        }

        if(distance < 0){
            throw new IllegalArgumentException("자동차 초기 위치는 음수가 될 수 없다");
        }

        this.name = name;
        this.distance = distance;
    }

    public static Car newInstance(String name, int distance){
        return new Car(name, distance);
    }

    public void go(int value) {
        if (isEnoughValue(value)) {
            distance++;
        }
    }

    public boolean isEnoughValue(int value) {
        return CONDITION_VALUE <= value;
    }

    @Override
    public int getDistance(){
        return distance;
    }

    @Override
    public String printDistance(String mark) {
        return mark.repeat(distance);
    }

    @Override
    public String getName(){
        return this.name;
    }
}
