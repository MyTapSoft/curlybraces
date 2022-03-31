package com.curlybraces.main.repository;

public interface CrudRepository<T, V> {
    int save(T entity);
}
