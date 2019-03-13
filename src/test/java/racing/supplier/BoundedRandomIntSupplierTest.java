package racing.supplier;

import org.junit.*;

import java.util.function.IntSupplier;

import static org.assertj.core.api.Assertions.assertThat;

public class BoundedRandomIntSupplierTest {

    @Test
    public void test_랜덤값_생성() {
        int bound = 10;
        IntSupplier supplier = new BoundedRandomIntSupplier(bound);
        for (int i = 0; i < 100; i++) {
            assertThat(supplier.getAsInt()).isLessThan(bound);
        }
    }
}