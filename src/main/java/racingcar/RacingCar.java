package racingcar;

public class RacingCar implements Car {
    RacingCar(String name) {
        this.name = name;
    }
    private int position;
    private String name;
    @Override
    public void go() {

    }

    @Override
    public void print() {
        StringBuilder stringBuilder = new StringBuilder(name + ":");

        for (int i=0; i<position; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder);
    }
}