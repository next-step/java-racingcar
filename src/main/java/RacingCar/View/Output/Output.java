package RacingCar.View.Output;

import RacingCar.Model.Car;

import java.util.ArrayList;

public class Output {
    public void printOutput() {
        System.out.println("실행 결과");
    }


    public void printCurLoaction(ArrayList<Car> cars) {
        String result = "";

        for (Car car : cars) {
            result += car.getName() + " : ";

            for (int i = 0; i < car.getLocation(); i++) result += "-";

            result +="\n";
        }

        System.out.println(result);
    }

    public void printWinner(ArrayList<Car> name) {
        String result = "";

        for (int i = 0; i < name.size(); i++)
            result += name.get(i).getName() + ", ";

        result = result.substring(0, result.length() - 2);

        System.out.println(result + "가 최종 우승했습니다.");

    }
}
