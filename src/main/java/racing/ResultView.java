package racing;

public class ResultView {

    public void view(Circuit circuit) {
        System.out.println("실행 결과");
        for (int i = 0; i < circuit.getNumberOfRacing(); i++) {
            for (Car car : circuit.getCars()) {
                car.printMove(i);
            }
            System.out.println();
        }
    }
}
