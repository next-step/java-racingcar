public class Car implements Comparable<Car> {
    private final String name;
    public int distance;

    public Car(String name) {
        //todo 이름이 조건에 안맞을때 해당 이름을 제외한다.
        if (!ValidationUtils.isName5CharsOrLess(name)) {
            throw new IllegalStateException();
        }
        this.distance = 0;
        this.name = name;
    }

    public void run() {
        this.distance++;
    }

    public void stop() {
    }
}
