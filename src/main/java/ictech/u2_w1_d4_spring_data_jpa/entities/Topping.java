package ictech.u2_w1_d4_spring_data_jpa.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@NoArgsConstructor
@Entity
@DiscriminatorValue("Topping")
@ToString(callSuper = true, exclude = "pizzas")
public class Topping extends MenuItem {

    @ManyToMany(mappedBy = "toppings")
    private List<Pizza> pizzas;

    public Topping(String name, int calories, double price) {
        super(name, calories, price);
    }
}
