package racing;


public class Car {

    public final String name;

    public final int moveOption;
    public int position;

    public Car(String name){

        getNameSize(name);

        this.name = name;
        this.moveOption = 4;
        this.position = 0;
    }


    void getNameSize(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("이름이 5자를 초과했음");
        }
    }

    void move(int random){
        if(moveOption < random){
            position++;
        }
    }


}
