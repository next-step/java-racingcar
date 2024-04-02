import java.util.Objects;

public class Car {
    private Name name;
    private int position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void moveOnCondition(int num) {
        if (isMove(num)) {
            this.position++;
        }
    }

    private boolean isMove(int num) {
        if (num > 3) {
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car other = (Car) obj;
        return this.name == other.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
