package step4.domain;

public class Car {
    private final int condition = 4 ;
    Name name;
    Position position;

    public Car(String name) {
        this(new Name(name), new Position());
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(int randomValue) {
        if(condition < randomValue){
            position.plus();
        }
    }

    public boolean isMoving() {
        return myPosition() > 0;
    }

    public int myPosition() {
        return position.getPosition();
    }

    public String myName() {
        return name.getName();
    }

    public int bestScore(int grade) {
        if(myPosition() > grade){
            grade = myPosition();
        }
        return grade;
    }

    public boolean isWinner(int grade){
        return (grade == 0 ) ? false : this.myPosition() == grade;
    }
}
