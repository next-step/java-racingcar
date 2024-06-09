package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(String name){
        nameCheck(name);
        this.name = name;
        this.position = 0;
    }

    private void nameCheck(String name){
        if(name==null || name.trim().isEmpty() || name.length()>=5){
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
    }

    public void move(boolean move){
        if(move){
            position ++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
