package racinggame.view;

import racinggame.domain.entity.Car;

public class CarLocationView implements Car.ReportingCar {
    private static final String empty = "\0";
    private static final String marker = "-";
    private static final int START_LINE = 1;

    @Override
    public void report(Car car) {
        String carName = car.getName();
        String locationExpression = new String(new char[car.getLocation().getValue() + START_LINE]).replace(empty, marker);
        String expression = carName + " : " + locationExpression;
        System.out.println(expression);
    }
}
