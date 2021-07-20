package racingcar;

import java.util.Objects;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        if(name.length()>5){
            throw new RuntimeException();
        }
        this.name = name;
        this.position = 1;
        print();
    }

    public Car(String name, int position){
        if(name.length()>5){
            throw new RuntimeException();
        }
        this.name = name;
        this.position = position;
        print();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNumber) {
        if(isMove(randomNumber)){
            this.position++;
        }
        print();
    }

    public boolean isMove(int randomNumber) {
        final int MOVE_NUM = 4;
        if(randomNumber>=MOVE_NUM){
            return true;
        }
        return false;
    }

    private void print(){
        System.out.print(name + " : ");
        for(int i=0; i<position; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean isWinner() {
        final int WINNER_POSITION = 5;
        if(this.position == WINNER_POSITION){
            return true;
        }
        return false;
    }
}
