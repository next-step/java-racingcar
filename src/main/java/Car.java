import java.util.function.Predicate;

public class Car {
    private String name;
    private int distance;

    private Car(String name) {
        this.distance = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public static Car createCar(String name){
        //todo 이름이 조건에 안맞을때 해당 이름을 제외한다.
        if (!ValidationUtils.isName5CharsOrLess(name)) {
            return null;
        }
        return new Car(name);
    }

    public void run() {
        this.distance++;
    }

    public void stop() {
    }

    public boolean matchName(String name) {
        return this.name == name;
    }

    public boolean matchDistance(int distance) {
        return this.distance == distance;
    }

}
