package racing;

/*
    ########################################################
    모든 운행이 종료된후에 출력을 해야되다보니
    3중 포문을 사용했내요-0-;;

    가독성에 문제가 되겠죠? 머리를 아무리 쥐어짜도 다른 방법이
    생각이 안나내요.

    ########################################################
 */


public class RacingGameResultVIew {

    private final static String CAR_MOVE_CHARTER = "-";

    public static void racingResultView(RacingGame rg) {
        System.out.println("실행 결과");

        for (int i = 0; i < rg.getTime(); i++) {
            for (int j = 0; j < rg.getList().size(); j++) {
                String outputValue = "";
                for (int k = 0; k < rg.getList().get(j).getMoveValues().get(i); k++) {
                    outputValue += CAR_MOVE_CHARTER;
                }

                System.out.println(outputValue);
            }
            System.out.println();
        }
    }
}
