public class Car {

    private String name;
    private int distance;

    public Car(String name, int distance) {
        checkLengthOfName(name);
        this.name = name;
        this.distance = distance;
    }

    private void checkLengthOfName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름이 5자 이상이 될 수 없습니다! : " + name);
        }
    }

    public void go(boolean condition) {
        if (condition) {
            this.distance++;
        }
    }

    public String name() {
        return this.name;
    }

    public int distance() {
        return this.distance;
    }
}
