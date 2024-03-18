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
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    private void printPosition(int position){
        for(int count = 0; count < position; count++){
            System.out.print("-");
        }
    }
}