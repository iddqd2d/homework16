package com.people.servies;

import java.util.List;
import java.util.Optional;

public interface Service<T> {

    Optional<T> read(int id);

    void create(T item);

    void update(T item);

    void delete(T item);

    List<T> list ();
}
