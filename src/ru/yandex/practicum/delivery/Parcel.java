package ru.yandex.practicum.delivery;

abstract class Parcel {
    private final String description;
    private final String deliveryAddress;
    private final int weight;
    private final int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public int getSendDay() {
        return sendDay;
    }

    public int getWeight() {
        return weight;
    }

    public abstract int getPrice();

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDescription() {
        return description;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + getDescription() + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + getDescription() + ">> доставлена по адресу " + getDeliveryAddress());
    }

    public double calculateDeliveryCost() {
        return weight*getPrice();
    }

}