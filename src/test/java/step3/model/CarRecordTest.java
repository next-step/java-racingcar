package step3.model;

import org.junit.jupiter.api.Test;

public class CarRecordTest {

    @Test
    void recordSave(){
        CarRecord record = new CarRecord();

        int numofcar = 4;
        int tries =3;
        record.resultRecording(numofcar,tries);

    }

}
