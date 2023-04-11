package racingcar;

public class Billboard {

    private final static String SEPARATOR = "-";
    private final static String NOTICE_MENT = "실행 결과";

    private Billboard() {
    }

    public static void notice() {
        System.out.println(NOTICE_MENT);
    }

    public static void result(WatingCars watingCars) {
        for (Car car : watingCars.getCars()) {
            print(car);
            lineBreak();
        }
        lineBreak();
    }

    private static void print(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(SEPARATOR);
        }
    }

    private static void lineBreak() {
        System.out.println();
    }

}
