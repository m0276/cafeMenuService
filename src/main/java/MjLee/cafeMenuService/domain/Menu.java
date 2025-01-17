package MjLee.cafeMenuService.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private int price;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long l){this.number = l;}

    @Override
    public String toString() {
        return "Menu{" +
                "name = '" + name + "'" +
                ", price ="  + price +
                '}';
    }
}
