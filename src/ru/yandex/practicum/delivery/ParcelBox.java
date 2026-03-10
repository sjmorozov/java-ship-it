package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private final int maxWeight;
    private final List<T> box = new ArrayList<>();
    private int currentWeight = 0;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }


    public boolean addParcel (T parcel) {
        if((currentWeight + parcel.getWeight()) <= maxWeight) {
            box.add(parcel);
            currentWeight += parcel.getWeight();
            System.out.println("Посылка <<" + parcel.getDescription() + ">> добавлена!");
            return true;
        } else {
            System.out.println("Коробка переполнена!");
            return false;
        }
    }

    public List<T> getAllParcels() {
        return box;
    }

    public void clear() {
        box.clear();
        currentWeight = 0;
    }

}