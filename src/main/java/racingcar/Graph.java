package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private Car car;
    public Graph(Car car) {
        this.car = car;
    }

    public void getCarGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.car.getPosition(); i++) {
            sb.append("-");
        }
        System.out.print(sb.toString());
        System.out.println();

    }
}
