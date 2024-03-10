package step3;

public class Car {

    String name;
    int position = 0;

    public Car(int i) {
        this.name = String.valueOf(i);
    }

    public RaceResultMap move(int attempt, Policy policy) {
        if (isNotFist(attempt)) {
            this.position = policy.apply(position);
        }
        return new RaceResultMap(name,position);
    }

    private static boolean isNotFist(int attempt) {
        return attempt != 0;
    }
}
