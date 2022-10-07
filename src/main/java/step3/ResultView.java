package step3;

public class ResultView {
    public void printResult(CarStorage carStorage, int tryCount) {
        System.out.println("실행 결과");
        carStorage.printLocation(tryCount);
    }
}
