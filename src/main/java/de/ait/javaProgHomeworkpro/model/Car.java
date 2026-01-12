package de.ait.javaProgHomeworkpro.model;

public class Car {

    private Long id;
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private int price;
    private String status;

    public Car(Long id, String brand, String model, int year,
               int mileage, int price, String status) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public int getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
