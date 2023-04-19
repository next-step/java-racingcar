package RacingCar.Output;

public class ResultView {

    void resultMessage() {
        System.out.println("실행 결과");
    }

    void printCar(StringBuffer inText) {
        System.out.println(inText);
    }

    void printSpace() {
        System.out.println("");
    }

    void finalWin(String names) {
        System.out.println(names + "가 최종 우승했습니다.");
    }
}
