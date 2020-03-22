package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRoundLogTest {
    private CarRoundLog carRoundLog;

    private String name1 = "seul";
    private String name2 = "pobi";
    private String name3 = "crong";

    @BeforeEach
    void setUp() {
        this.carRoundLog = new CarRoundLog();
    }

    @Test
    void addCarLogs() {
        carRoundLog.addCarLogs(name1, 10);
        carRoundLog.addCarLogs(name2, 2);
        carRoundLog.addCarLogs(name3, 3);

        assertThat(carRoundLog.getCarLogs()).hasSize(3);
        assertThat(carRoundLog.getCarLogs().get(0).getName()).isEqualTo(name1);
        assertThat(carRoundLog.getCarLogs().get(1).getName()).isEqualTo(name2);
        assertThat(carRoundLog.getCarLogs().get(2).getName()).isEqualTo(name3);
    }
}
