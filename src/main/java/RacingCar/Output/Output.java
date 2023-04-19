package RacingCar.Output;

import RacingCar.Winner;

import java.util.ArrayList;

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

    public void printWinner(ArrayList<Winner> name) {
        String result = "";

        for (int i = 0; i < name.size(); i++)
            result += name.get(i).getName() + ", ";

        result = result.substring(0, result.length() - 2);

        resultView.finalWin(result);

    }
}
