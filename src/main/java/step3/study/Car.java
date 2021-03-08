package step3.study;

public class Car {
    private String distance = "-";
    private static int MOVE_CONDITION = 4;

    public void move() {
        if (MOVE_CONDITION <= RacingUtil.createRandomNubmer()) {
            this.distance += "-";
        }
        ResultView.printDistacne(this.distance);
    }
}
