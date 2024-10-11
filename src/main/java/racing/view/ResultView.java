package racing.view;

import racing.entity.Car;

import java.util.List;

public class ResultView {
    public void printResult(List<Car> cars) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 090df7a39 (fix: 테스트 수정)
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> result.append(buildCarResult(car)).append("\n"));
        System.out.println(result.toString());
    }

    private String buildCarResult(Car car) {
        return car.getName() + ": " + carPosition(car.getPosition());
    }

    private String carPosition(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
<<<<<<< HEAD
        }
        return sb.toString();
    }
}

=======
        for (Car car : cars) {
            System.out.print(car.getName() + ": ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
=======
>>>>>>> 090df7a39 (fix: 테스트 수정)
        }
        return sb.toString();
    }
}
<<<<<<< HEAD
>>>>>>> 6186238e5 (feat: 테스트 작성)
=======

>>>>>>> 090df7a39 (fix: 테스트 수정)
