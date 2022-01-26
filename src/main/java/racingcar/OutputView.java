package racingcar;

public class OutputView {
    public static void printCurrent(String[] carNames, int[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.print(carNames[i] + " : ");
            for (int j = 0; j < cars[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static int getMaxScore(int[] cars){
        int maximum=0;
        for (int i = 0; i < cars.length; i++) {
            maximum = Math.max(maximum, cars[i]);
        }
        return maximum;
    }

    public static void printWinners(String[] carNames, int[] cars) {
        int count=0;
        int maximum = getMaxScore(cars);
        System.out.print("최종 우승자: ");
        for (int i=0; i < cars.length; i++) {
            if (cars[i] != maximum) {
                continue;
            }
            if (count != 0) {
                System.out.print(", ");
            }
            System.out.print(carNames[i]);
            count++;
        }
    }
}
