package cc.oakk.racing.printer;

import cc.oakk.racing.Car;

public class CarPrinter extends StringPrinter<Car> {
    private static final String DISTANCE_SYMBOL = "-";

    public CarPrinter() {
        super();
    }

    public CarPrinter(Printer<String> stringPrinter) {
        super(stringPrinter);
    }

    @Override
    public void print(Car source) {
        if (source == null) {
            throw new IllegalArgumentException("source is null!");
        }

        String carString = createCarString(source);
        stringPrinter.print(carString);
    }

    private String createCarString(Car car) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < car.getMovedDistance(); i++) {
            builder.append(DISTANCE_SYMBOL);
        }
        builder.append("\n");
        return builder.toString();
    }
}
