package car.racing;

import java.util.List;

public interface CarRacingContract {

    interface View {

        void resultTitle();
        void newLine();
        void forward(List<Car> cars);
    }
}
