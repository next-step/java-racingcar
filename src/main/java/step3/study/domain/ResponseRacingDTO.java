package step3.study.domain;

import java.util.*;

public class ResponseRacingDTO {
    private Cars cars;
    private List<Recodes> recodesList;

    public ResponseRacingDTO(List<Recodes> recodesList) {
        this.recodesList = recodesList;
    }

    public ResponseRacingDTO(Cars cars, List<Recodes> recodesList) {
        this.cars = cars;
        this.recodesList = recodesList;
    }

    public Cars getCars() {
        return cars;
    }

    public List<Recodes> getRecodesList() {
        return recodesList;
    }
}
