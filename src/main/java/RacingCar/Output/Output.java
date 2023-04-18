package RacingCar.Output;

public class Output {
    static ResultView resultView = new ResultView();

    public void Output() {
        resultView.resultMessage();
    }

    public void location(String name, int num) {
        String result = name + " : ";

        for (int i = 0; i < num; i++)
            result += "-";

        System.out.println(result);
    }

    public void printSpace() {
        resultView.printSpace();
    }
}
