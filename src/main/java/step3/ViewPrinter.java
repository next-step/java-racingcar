package step3;


import step3.object.Car;

import java.util.List;

public class ViewPrinter {

    private List<Car> carList;

    public ViewPrinter(List<Car> carList) {
        this.carList = carList;
    }

    public void printCars() {
        for (Car car : this.carList) {
            printPositionWithName(car);
            System.out.println();
        }
        System.out.println();
    }

    private void printPositionWithName(Car car){
        System.out.print(car.getName() + " : ");
        for(int count = 0; count < car.getPosition(); count++){
            System.out.print("-");
        }
    }

    public void printWinners(List<Car> winnerList) {
        for (int index = 0; index < winnerList.size(); index++) {
            System.out.print(winnerList.get(index).getName());
            printColon(winnerList, index);
            System.out.println("가 최종 우승했습니다.");
        }
    }

    private void printColon(List<?> objectList, int index){
        if (index < objectList.size() - 2) {
            System.out.print(", ");
        }
    }
}