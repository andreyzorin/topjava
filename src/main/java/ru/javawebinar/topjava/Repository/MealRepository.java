package ru.javawebinar.topjava.Repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface MealRepository {
    void save(Meal meal);

    void create(Meal meal);

    void delete(int id);

    Meal get(int id);

    Collection<Meal> getAll();
}
