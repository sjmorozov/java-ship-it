package ru.yandex.practicum;

import ru.yandex.practicum.delivery.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StandardParcelTest {

    @Test
    void calculateDeliveryCost_normalWeight_returnsCorrectCost() {

        StandardParcel parcel =
                new StandardParcel("Яндекс.станция", 2, "Великий Новгород", 10);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(4, cost);
    }

    @Test
    void calculateDeliveryCost_differentWeight_returnsCorrectCost() {

        StandardParcel parcel =
                new StandardParcel("Тумбочка", 10, "Великий Новгород", 1);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(20, cost);
    }

    @Test
    void calculateDeliveryCost_zeroWeight_returnsZero() {

        StandardParcel parcel =
                new StandardParcel("Куб воздуха", 0, "Великий Новгород", 13);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(0, cost);
    }

}