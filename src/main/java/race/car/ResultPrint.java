package race.car;

public class ResultPrint {

    /**
     * 자동차 그리기
     *
     * @param carImformation
     */
    public static CarImformation showCarImformation(CarImformation carImformation) {
        for (int i = 0; i < carImformation.getCarCount(); i++) {
            goInTryMove(carImformation.getTryMoveCount());
            System.out.println();
        }
        return carImformation;
    }

    /**
     * 자동차의 이동횟수 배열 들어가기
     *
     * @param tryMoveCount
     */
    private static void goInTryMove(int[] tryMoveCount) {
        CarMove.MOVE.carMove(tryMoveCount);

        for (int i = 0; i < tryMoveCount.length; i++) {
            ResultPrint.showCarMovePrint(tryMoveCount[i]);
            System.out.println();
        }
    }

    /**
     * 자동차 이동횟수 그리기
     *
     * @param tryMoveCount
     */
    private static void showCarMovePrint(int tryMoveCount) {
        for (int j = 0; j < tryMoveCount; j++) {
            System.out.print("-");
        }
    }

}
