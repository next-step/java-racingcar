public class View {

    public void requestCarCount() {
        System.out.println("자동차는 몇 대인가요?");
    }

    public void requestTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

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
}