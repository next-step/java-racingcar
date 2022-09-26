package carracing.step4;

import java.util.List;

public class ResultView {

    public void printEachPlayResult(List<CarVo> result, int playCount) {
        if (playCount == 0) {
            System.out.println("실행 결과");
        }
        for (CarVo carVo : result) {
            System.out.printf("%s : %s\n", carVo.getName(), "-".repeat(carVo.getMoveCnt()));
        }
        System.out.println();
    }

    public void printWinner(List<String> carNames) {
        String carJoinNames = String.join(", ", carNames);
        System.out.printf("%s가 최종 우승했습니다.", carJoinNames);
    }
}
