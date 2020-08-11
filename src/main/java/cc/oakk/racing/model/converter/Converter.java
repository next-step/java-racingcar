package cc.oakk.racing.model.converter;

public interface Converter<T, E> {
    E convert(T from);
}
