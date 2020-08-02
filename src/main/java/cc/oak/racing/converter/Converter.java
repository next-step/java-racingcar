package cc.oak.racing.converter;

public interface Converter<T, E> {
    E convert(T from);
}
