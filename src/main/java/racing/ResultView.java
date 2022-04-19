package racing;

public class ResultView {

    public static void view(Circuit circuit) {
        System.out.println("실행 결과");
        for (int i = 0; i < circuit.getNumberOfRacing(); i++) {
            System.out.printf("%d 회 \n", i + 1);
            for (Car car : circuit.getCars()) {
                car.printMove(i);
            }
        }
    }
}
