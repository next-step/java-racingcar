package com.jaeyeonling.calculator;

@FunctionalInterface
public interface BiOperation<T> {
    T apply(T a, T b);
}
