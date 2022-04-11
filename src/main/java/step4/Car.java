package step4;

public class Car {
    private String name;
    private final StringBuilder distance;

    public Car(String name) throws Exception {
        if (name.length() > 5) {
            throw new Exception("이름은 5자를 초과할 수 없습니다");
        }

        this.distance  = new StringBuilder();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance.toString();
    }

    public String move(int number) {
        if (number < 4) {
            return "";
        }

        this.distance.append("-");
        return this.distance.toString();
    }

    public void print() {
        System.out.println(this.name + " : " + this.distance.toString());
    }
}
