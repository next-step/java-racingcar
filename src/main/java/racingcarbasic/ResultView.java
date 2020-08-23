package racingcarbasic;


import java.util.List;

public class ResultView {
    public ResultView() {
        System.out.println("\n실행 결과");
    }

    public void printResult(RacingCars racingCars) {
        racingCars.getCarList()
                .forEach(car -> {
                    int step = car.getStep();
                    System.out.println(car.getName() + " : " + new String(new char[step]).replace("\0", "-"));
                });
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        winners.forEach(winner -> sb.append(winner).append(", "));
        sb.setLength(sb.length() - 2);
        sb.append("가 최종 우승했습니다.");

        System.out.println(sb.toString());
    }
}
