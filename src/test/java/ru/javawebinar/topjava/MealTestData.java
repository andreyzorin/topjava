package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int MEAL_ID = START_SEQ + 2;
    public static final int MEAL_ADMIN_ID = START_SEQ + 9;

    public static final Meal meal1 = new Meal(MEAL_ID, of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500);
    public static final Meal meal2 = new Meal(MEAL_ID + 1, of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000);
    public static final Meal meal3 = new Meal(MEAL_ID + 2, of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500);
    public static final Meal meal4 = new Meal(MEAL_ID + 3, of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100);
    public static final Meal meal5 = new Meal(MEAL_ID + 4, of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 500);
    public static final Meal meal6 = new Meal(MEAL_ID + 5, of(2020, Month.JANUARY, 31, 13, 0), "Обед", 1000);
    public static final Meal meal7 = new Meal(MEAL_ID + 6, of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 510);
    public static final Meal adminMeal1 = new Meal(MEAL_ADMIN_ID, of(2020, Month.JANUARY, 31, 14, 0), "Админ ланч", 510);
    public static final Meal adminMeal2 = new Meal(MEAL_ADMIN_ID + 1, of(2020, Month.JANUARY, 31, 21, 0), "Админ ужин", 1500);

    public static final List<Meal> meals = Arrays.asList(meal7, meal6, meal5, meal4, meal3, meal2, meal1);

    public static Meal getNewMeal() {
        return new Meal(null, of(2021, Month.MAY, 11, 11, 11), "NEW", 111);
    }

    public static Meal getUpdatedMeal() {
        return new Meal(MEAL_ID, meal1.getDateTime(), "UPDATED", 666);
    }

    public static void assertMatchMeal(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertMatchMeal(Iterable<Meal> actual, Meal... expected) {
        assertMatchMeal(actual, Arrays.asList(expected));
    }

    public static void assertMatchMeal(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }
}
