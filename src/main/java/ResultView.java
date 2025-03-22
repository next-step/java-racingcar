public final class ResultView {

    private ResultView() {}

    public static void printResult(final CarsSnapShots carsSnapShots) {
        carsSnapShots.getCars().forEach(cars -> {
            cars.getCars().forEach(car -> {
                printCarPosition(car.getPosition());
                System.out.println();
            });
            System.out.println();
        });
    }

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    private static void printCarPosition(int position) {
        System.out.print("-".repeat(position));
    }
}
