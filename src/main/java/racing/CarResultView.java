package racing;

import racing.message.ViewMessage;

import java.util.List;

public class CarResultView {
    private void resultViewMessage() {
        System.out.println(ViewMessage.START_RESULT_VIEW.getMessage());
    }

    private String getLocationLineView(int location) {
        String result = "";
        for(int i = 0; i < location; i++) {
            result += "-";
        }
        return result;
    }

    private void carRunWithResultView(List<Car> carList) {
        carList.forEach(car -> {
            car.run();
            System.out.println(getLocationLineView(car.getLocation()));
        });
    }

    public void resultViewPrint(int tryCount, List<Car> carList) {
        resultViewMessage();
        for (int i = 0; i < tryCount; i++) {
            carRunWithResultView(carList);
            System.out.println();
        }
    }
}
