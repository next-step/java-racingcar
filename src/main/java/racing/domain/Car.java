package racing.domain;

public class Car {

    public final String name;

    public final int moveOption;

    private int position;

    public Car(String name){
        this(name, 0);
    }

    public Car(String name, int position){
        vaildName(name);

        this.position = position;
        this.name = name;
        this.moveOption = 4;
    }

    private void vaildName(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("이름이 5자를 초과했음");
        }
    }

    public boolean move(int moveValue){
        boolean isMove = false;

        if(moveOption <= moveValue){
            position++;
            isMove = true;
        }

        return isMove;
    }





    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}