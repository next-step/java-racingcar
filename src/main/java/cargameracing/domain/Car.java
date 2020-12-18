package cargameracing.domain;

/**
 * Car Object
 * @author minji
 */
public class Car {
    private Name name;
    private Position junjin = new Position();

    public Car(String name) {
        this.name = new Name(name);
    }

    public void junjinUp(MovingStrategy MovingStrategy) {
        if (MovingStrategy.isMove()) {
            junjin.move();
        }
    }

    public String getName() { return name.getName(); }
    public int getJunjin() { return junjin.getPosition(); }
}
