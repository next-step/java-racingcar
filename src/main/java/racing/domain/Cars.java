package racing.domain;

import org.assertj.core.util.Lists;

import java.util.List;

public class Cars {
    public Cars(int carNum) {

    }

    public Cars(List<Car> carsList) {

    }

    public int size() {
        return -1;
    }

    public List<Car> getList() {
        return null;
    }

    public List<Integer> getCarsPositionList() {
        return Lists.emptyList();
    }
}
