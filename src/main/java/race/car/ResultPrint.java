package race.car;

/**
 * 결과를 그려주는 객체
 */
public class ResultPrint {

    public static void drawMoveCar(int[] carMoveCountArr) {
        for (int i = 0; i < carMoveCountArr.length; i++) {
            insideArr(carMoveCountArr[i]);
        }
        System.out.print("\n");
    }

    private static void insideArr(int inputValue) {
        for (int i = 0; i < inputValue; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
