package racing.car.view;

public class ResultView {

    public static void startCycle(int carNumber, int count) {
        System.out.println("자동차" + carNumber + "대 " + count + "회");
        System.out.println("실행 결과");
    }

    public static void resultGoAndStop(int[] cars) {
        for (int i = 0; i < cars.length; i++) {
            for (int j = 0; j < cars[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
