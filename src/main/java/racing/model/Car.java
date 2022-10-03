package racing.model;

import racing.strategy.CarMoveStrategy;
import racing.strategy.DefaultCarMoveStrategy;

public class Car {
    private final static String TIREMARK = "-";
    private final static int SPEED = 1;

    private CarPosition position;
    private CarMoveStrategy carMoveStrategy;
    private CarName name;

    public Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
        setDefaultCarMoveStrategy();
    }
    public Car(String name, int position) {
        this(new CarName(name), new CarPosition(position));
    }

    public Car(String name) {
        this(new CarName(name), new CarPosition());
    }

    public void setDefaultCarMoveStrategy() {
        setStrategy(new DefaultCarMoveStrategy());
    }

    public String getTireMark() {
        return TIREMARK;
    }

    public void move() {
        position.move(SPEED);
    }

    public boolean canMove(int randomNum) {
        return carMoveStrategy.canMove(randomNum);
    }

    public void setStrategy(CarMoveStrategy carMoveStrategy) {
        this.carMoveStrategy = carMoveStrategy;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return this.name.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;
        if (!car.getName().equals(this.getName())) {
            return false;
        }

        return car.position.getPosition() == this.position.getPosition();
    }

    public String getSkidMark(){
        String skidMark = getName() + " : ";
        for (int i = 0; i < this.getPosition(); i++) {
            skidMark += this.getTireMark();
        }
        return skidMark;
    }
}
