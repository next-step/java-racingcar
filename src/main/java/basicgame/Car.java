package basicgame;

import util.StringUtil;

public class Car implements Vehicle {
    private final static int CONDITION_VALUE = 4;
    private final static int MAX_NAME_SIZE = 5;
    private int distance = 1;
    private String name;


    public Car(String name) {
        if(StringUtil.isBlank(name)){
            throw new NullPointerException("자동차 이름은 null이나 빈공백은 불가능");
        }
        if(name.length() > MAX_NAME_SIZE){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다");
        }
        this.name = name;
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
        StringBuilder stringBuffer = new StringBuilder();
        for(int i =0; i<distance; i++) {
            stringBuffer.append(mark);
        }
        return stringBuffer.toString();
    }

    @Override
    public String getName(){
        return this.name;
    }
}
