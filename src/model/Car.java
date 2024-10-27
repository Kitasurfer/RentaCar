package model;

/* Группа: 52-1, "AIT Hi-tech team" GMBH
Автор: Богдан Фесенко
Дата: 24-10-2024
*/

public class Car {
    private final int id;
    private String model;
    private final int year;
    private double price;
    private boolean isBusy;

    public Car(int id, String model, int year, double price) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isBusy = false;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", isBusy=" + isBusy +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void markAsBusy() {
        this.isBusy = true;
    }

    public void markAsFree() {
        this.isBusy = false;
    }
}
