package racing.ui;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FormTest {

    @Test
    void 쉼표가_포함된_자동차_이름을_받아서_배열로_전환(){
        Form form = new Form("씽씽,띠띠,뚜뚜", 5);

        Assertions.assertThat(form.getNameOfCars()).isEqualTo(new String[]{"씽씽", "띠띠", "뚜뚜"});
    }

}