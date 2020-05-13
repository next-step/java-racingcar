package CarRacing;

import java.util.List;

public class CarRacingView extends View{

    private final String POSITION_STRING = "-";

    @Override
    public void view() {
        System.out.println("CarRacing View");
    }

    public void view(List<Car> carList) {
        initView();
        carList.stream().forEach( car -> {
            for(int i=0 ; i <= car.getPosition().location; i++) {
                System.out.print(POSITION_STRING);
            }
            System.out.println("");
        });
        endView();
    }

    @Override
    public void initView() {
        System.out.println("");
        System.out.println("실행결과");
    }

    @Override
    public void endView() {
        System.out.println("");
    }

}
