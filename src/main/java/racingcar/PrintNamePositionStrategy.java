package racingcar;

public class PrintNamePositionStrategy implements PrintStrategy {
    @Override
    public void print(Car car) {
        String format = String.format("%-5s : %s", car.getName(), "-".repeat(car.getPosition()));
        System.out.println(format);
    }
}
