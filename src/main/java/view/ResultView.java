package view;

public class ResultView {
    public void printResult() {
        System.out.println("실행결과 :");
    }

    public String printMovingPattern() {
        return "-";
    }

    public void printSeperateCar() {
        System.out.println("@@@@@@@@@@@");
    }

    public void printCarMoving(String result) {
        System.out.println(result);
    }

    public void printWinner(String winner) {
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}