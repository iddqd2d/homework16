package com.people.servies;

import java.util.List;

public interface Service<T> {

    T read(int id);

    void create(T item);

    void update(T item);

    void delete(T item);

    List<T> list ();
}
