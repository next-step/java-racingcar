package racinggame;

import racinggame.Car.CarDto;
import racinggame.SnapShotStore.SnapShot;

public class OutPutView {

    private static final String HYPHEN = "-";

    public static void render(SnapShot snapShot) {
        System.out.println("실행 결과");
        for (int count = 0; count < snapShot.repeatCount(); count++) {
            renderCars(snapShot, count);
        }
    }

    private static void renderCars(SnapShot snapShot, int count) {
        for (CarDto carDto : snapShot.getSnapShot(count)) {
            System.out.println(renderHyphen(carDto.position()));
        }
        System.out.println();
    }

    private static String renderHyphen(int count) {
        return HYPHEN.repeat(count);
    }
}
