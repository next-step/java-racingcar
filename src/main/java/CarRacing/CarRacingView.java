package CarRacing;

import java.util.List;

public class CarRacingView implements View{

    private final String POSITION_STRING = "-";

    @Override
    public void view() {
        System.out.println("CarRacing View");
    }

    public void view(List<Car> carList) {
        initView();
        StringBuffer resultString = new StringBuffer();
        carList.stream().forEach( car -> {
            for(int i=0 ; i <= car.getLocation(); i++) {
                resultString.append("-");
            }
            resultString.append("\n");
        });
        System.out.println(resultString.toString());
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
