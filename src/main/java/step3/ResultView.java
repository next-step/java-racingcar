package step3;

public class ResultView {

    public void printResult(Cars cars) {
        System.out.println("실행 결과");
        cars.getCars().forEach(car -> {
            printCarPosition(car);
            System.out.println();
        });
    }

    private void printCarPosition(Car car) {
        for(int i =0 ; i< car.getPosition(); i++) {
            System.out.print("-");
        }
    }
}
