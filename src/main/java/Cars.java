import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean isSize(int size) {
        return cars.size() == size;
    }

    public void start(Referee referee, int howManyTimes) {
        for (int i = 0 ; i < howManyTimes; i++) {
            judge(referee);
        }
    }

    private void judge(Referee referee) {
        for (Car each : cars) {
            referee.judge(each);
        }
    }
}
