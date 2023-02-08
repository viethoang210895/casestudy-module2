package CaseStudy;

import java.io.Serializable;

public class Phone implements Serializable {
    public static int INDEX=0;
    Integer id;
    String name;
    String color;
    String country;
    Long price;
    Integer amount;


    public Phone() {
    }

    public Phone( String name, String color, String country, Long price, Integer amount) {
        this.id = Integer.valueOf(++INDEX);
        this.name = name;
        this.color = color;
        this.country = country;
        this.price = price;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

}
