package project.calculator;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public interface Number {

    @NotNull
    Number plus(@Nullable Number number);
    @NotNull
    Number minus(@Nullable Number number);
    @NotNull
    Number multiply(@Nullable Number number);
    @NotNull
    Number divide(@Nullable Number number);

    @NotNull
    Number toNegative();
    @NotNull
    String toString();
}
