package study.step3;

public class Car{

    private Name name;
    private Position position;

    public Car(){
        this(new Name());
    }

    public Car(Name name){
        this(name,new Position());
    }

    public Car(Name name,Position position){
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy){
        if(moveStrategy.isMove()){
            position.move();
        }
    }

    public Position position(){
        return position;
    }

    public Name name(){
        return name;
    }
}
