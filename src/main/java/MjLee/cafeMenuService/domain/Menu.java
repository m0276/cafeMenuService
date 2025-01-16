package MjLee.cafeMenuService.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
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
}
