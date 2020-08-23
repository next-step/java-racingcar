package pobiRacingCar.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    public static final int MAX_BOUND = 10;
    public static final int FORWARD_NUM = 4;
    //private final String name; //원시값 name -> Name Obj, 그 자체 validation가능.
    private final CarName name; //init null
    private Position position = new Position(0); //init 0
    // private int position = 0; //원시값 position -> Position Obj , 그 자체 validation가능.

    public Car(final String name) { //원시값 name -> Name Obj  this.name = name.trim();
        this(name, 0); //아래 호출 **
    }

    public Car(final String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position); //CarsTest : name & pos 포함 const
    }

    //public int getPosition() { return position; } 원시값 position -> Position Obj
    /** position에 move() 위임하니 getter/setter 불필요 ,DOMAIN 에서는 setter 불필요 getter은 UI용*/
    public Position getPosition() {
        return position;
    }

    //public String getName() { return name; }  원시값 name -> Name Obj
    public CarName getName() {
        return name;
    }

    //move() getRandom 즉 Random 객체에 의존 : 아예 외부에서 고정값(int 등)전달받게 하라
    public void move(int randomNo) {
        if (randomNo >= FORWARD_NUM)
        /**
         * 메시지 객체에 위임, Car이 position 강제않고 position 객체에게 자율성 보장!
         */
            position.move();
        //    this.position++;
    }
    /*
    public void move() {
        if (getRandomNo() >= FORWARD_NUM)
            this.position++;
    }
    그리고 아래의 getRandomNo()는 RacingGame 상위 노드 객체로 이동
    */

    public boolean isWinner(int maxPosition) {
        return this.position.isWinner(maxPosition);  //car이 winner인지 판단하려고 보니, 알 수 없으므로 position에게 메시지, 위임
    }

    public boolean isBigger(int maxPosition) {
        return this.position.isBigger(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Car car = (Car) o;
        return position == car.position &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}



