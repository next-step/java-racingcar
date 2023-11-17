package study.racingCar;

public class ResultView {

    public ResultView() {
    }

    public void printResult(){
        System.out.println("*********** 실행결과 ***********");
    }

    public void printRoundResult(Car car){
        car.printName();
        System.out.print(": ");
        car.printPosition();
        System.out.println();
    }
}
