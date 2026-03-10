package ru.yandex.practicum;

import ru.yandex.practicum.delivery.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParcelBoxTest {

    @Test
    void addParcel_whenWeightWithinLimit_returnsTrue() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(25);
        StandardParcel parcel =
                new StandardParcel("Тумбочка", 24, "Великий Новгород", 1);

        assertTrue(parcelBox.addParcel(parcel));
    }

    @Test
    void addParcel_whenWeightExceedsLimit_returnsFalse() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(25);
        StandardParcel parcel =
                new StandardParcel("Шкаф", 26, "Великий Новгород", 1);

        assertFalse(parcelBox.addParcel(parcel));
    }

    @Test
    void addParcel_whenWeightEqualsLimit_returnsTrue() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(25);
        StandardParcel parcel =
                new StandardParcel("Телевизор", 25, "Великий Новгород", 1);

        assertTrue(parcelBox.addParcel(parcel));
    }

    @Test
    void addParcel_whenTotalWeightExceedsLimit_returnsFalse() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(25);
        StandardParcel parcel1 =
                new StandardParcel("Системный блок", 15, "Великий Новгород", 1);
        StandardParcel parcel2 =
                new StandardParcel("Монитор", 11, "Великий Новгород", 1);

        assertTrue(parcelBox.addParcel(parcel1));
        assertFalse(parcelBox.addParcel(parcel2));
    }

}