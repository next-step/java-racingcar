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
            resultString.append(car.getName()).append(" : ");
            for(int i=0 ; i <= car.getLocation(); i++) {
                resultString.append("-");
            }
            resultString.append("\n");
        });
        System.out.println(resultString.toString());
        endView();
    }

    public void initView() {
        System.out.println("");
        System.out.println("실행결과");
    }

    @Override
    public void endView() {
        System.out.println("");
    }

    public void resultView(List<Car> winnerList) {
        StringBuffer resultString = new StringBuffer();
        winnerList.stream().forEach( car -> {
            resultString.append(car.getName()).append(", ");
        });
        resultString.append("가 최종 우승했습니다.");
        System.out.println(resultString.toString());
    }

}
