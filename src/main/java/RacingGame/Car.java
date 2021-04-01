package RacingGame;
import java.util.Random;
import java.util.function.Function;

public class Car {

    private int location;
    private String name;

    public Car(){
        this.location = 0;
    }

    public Car(String name){
        this.location = 0;
        if (notValidName(name)){
            throw new IllegalStateException("차의 이름은 5자 이하여야 합니다.");
        }
        this.name = name;

    }

    public int isAt(){
        return this.location;
    }

    public void applyRule(int location) {
        this.location = location;
    }

    public Boolean notValidName(String name){
        return name.length() > 5;
    }
}
