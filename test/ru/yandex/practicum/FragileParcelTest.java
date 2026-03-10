package ru.yandex.practicum;

import ru.yandex.practicum.delivery.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FragileParcelTest {

    @Test
    void calculateDeliveryCost_normalWeight_returnsCorrectCost() {

        FragileParcel parcel =
                new FragileParcel("Яндекс.станция", 2, "Великий Новгород", 10);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(8, cost);
    }

    @Test
    void calculateDeliveryCost_differentWeight_returnsCorrectCost() {

        FragileParcel parcel =
                new FragileParcel("Тумбочка", 10, "Великий Новгород", 1);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(40, cost);
    }

    @Test
    void calculateDeliveryCost_zeroWeight_returnsZero() {

        FragileParcel parcel =
                new FragileParcel("Куб воздуха", 0, "Великий Новгород", 13);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(0, cost);
    }
}