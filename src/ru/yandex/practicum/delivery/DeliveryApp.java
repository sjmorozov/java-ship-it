package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackableParcels = new ArrayList<>();

    private static final ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(25);
    private static final ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(25);
    private static final ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(25);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    showBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отследить посылку");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберите тип посылки:");
        System.out.println("1 - Стандартная посылка");
        System.out.println("2 - Скоропортящаяся посылка");
        System.out.println("3 - Хрупкая посылка");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите описание посылки");
        String description = scanner.nextLine();
        System.out.println("Введите вес посылки, кг");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес доставки");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Введите день отправки");
        int sendDay = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                if (standardParcelBox.addParcel(standardParcel)) {
                    allParcels.add(standardParcel);
                }
                break;
            case 2:
                System.out.println("Сколько дней может храниться посылка?");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                if (perishableParcelBox.addParcel(perishableParcel)) {
                    allParcels.add(perishableParcel);
                }
                break;
            case 3:
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                if (fragileParcelBox.addParcel(fragileParcel)) {
                    allParcels.add(fragileParcel);
                    trackableParcels.add(fragileParcel);
                }
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel p : allParcels) {
            p.packageItem();
            p.deliver();
        }
        allParcels.clear();
        trackableParcels.clear();
        standardParcelBox.clear();
        perishableParcelBox.clear();
        fragileParcelBox.clear();
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double sum = 0;
        for (Parcel p : allParcels) {
            sum += p.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок: " + sum + " руб.");
    }

    private static void reportStatus() {
        if (trackableParcels.isEmpty()) {
            System.out.println("Нет посылок с отслеживанием.");
            return;
        }
        System.out.println("Введите новое местоположение");
        String newLocation = scanner.nextLine();
        for (Trackable t : trackableParcels) {
            t.reportStatus(newLocation);
        }
    }


    private static void showBox() {
        System.out.println("Какую коробку показать?");
        System.out.println("1 - Стандартная");
        System.out.println("2 - Скоропортящаяся");
        System.out.println("3 - Хрупкая");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                showBox(standardParcelBox);
                break;
            case 2:
                showBox(perishableParcelBox);
                break;
            case 3:
                showBox(fragileParcelBox);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void showBox(ParcelBox<? extends Parcel> parcelBox) {
        for (Parcel p : parcelBox.getAllParcels()) {
            System.out.println(p.getDescription());
        }
    }

}