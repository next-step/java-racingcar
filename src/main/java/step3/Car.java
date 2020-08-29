package step3;

public class Car {

    private final String name;
    private int currentPosition;

    Car(String name){
        if(name.length() > Constant.CAR_NAME_LENGHT_LIMIT){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int moveForward(boolean isSuccess){
        if(isSuccess){
            currentPosition++;
        }
        return currentPosition;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

    public String getName(){
        return this.name;
    }

}