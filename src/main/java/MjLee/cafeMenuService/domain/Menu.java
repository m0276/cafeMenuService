package MjLee.cafeMenuService.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long l){this.id = l;}

    @Override
    public String toString() {
        return "Menu{" +
                "name = '" + name + "'" +
                ", price = "  + price +
                '}';
    }
}
