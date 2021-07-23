package racing;

class Car implements Racer {
    private static final String MARK = "-";

    private String name;
    private String position;

    private Car(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name, String position) {
        return new Car(name, position);
    }

    public static Car emptyCar() {
        return new Car("", "");
    }

    @Override
    public Car go() {
        this.position += MARK;
        return this;
    }

    @Override
    public String position() {
        return position;
    }
}
