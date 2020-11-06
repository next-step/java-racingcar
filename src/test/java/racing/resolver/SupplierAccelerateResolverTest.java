package racing.resolver;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SupplierAccelerateResolverTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testSupplierAccelerateResolver(int input) {
        SupplierAccelerateResolver supplierAccelerateResolver = new SupplierAccelerateResolver(() -> input % 2 == 1);
        boolean resolve = supplierAccelerateResolver.resolve();
        assertThat(resolve).isEqualTo(input % 2 == 1);
    }
}
