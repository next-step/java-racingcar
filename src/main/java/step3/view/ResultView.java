package step3.view;

import step3.model.Car;

public class ResultView {
    public static void resultShow(Car[] cars){
        for(int i=0; i< cars.length;i++){
            for(int k=0; k< cars[i].getPosition();k++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
