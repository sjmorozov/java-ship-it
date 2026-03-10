package ru.yandex.practicum;

import ru.yandex.practicum.delivery.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PerishableParcelTest {

    @Test
    void calculateDeliveryCost_normalWeight_returnsCorrectCost() {

        PerishableParcel parcel =
                new PerishableParcel("Брусничное варенье", 1, "Великий Новгород", 10, 10);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(3, cost);
    }

    @Test
    void calculateDeliveryCost_differentWeight_returnsCorrectCost() {

        PerishableParcel parcel =
                new PerishableParcel("Бочка солёных огурцов", 10, "Великий Новгород", 12, 7);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(30, cost);
    }

    @Test
    void calculateDeliveryCost_zeroWeight_returnsZero() {

        PerishableParcel parcel =
                new PerishableParcel("Воспоминания", 0, "Великий Новгород", 7, 5);

        double cost = parcel.calculateDeliveryCost();

        assertEquals(0, cost);
    }

    @Test
    void isExpired_expiredParcel_returnsTrue() {
        PerishableParcel parcel =
                new PerishableParcel("Воспоминания", 0, "Великий Новгород", 7, 5);

        assertTrue(parcel.isExpired(15));
    }

    @Test
    void isExpired_freshParcel_returnsFalse() {
        PerishableParcel parcel =
                new PerishableParcel("Воспоминания", 0, "Великий Новгород", 7, 5);

        assertFalse(parcel.isExpired(10));
    }

    @Test
    void isExpired_onExpirationDay_returnsFalse() {
        PerishableParcel parcel =
                new PerishableParcel("Воспоминания", 0, "Великий Новгород", 7, 5);

        assertFalse(parcel.isExpired(12));
    }

}