package ictech.u2_w1_d4_spring_data_jpa.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@DiscriminatorValue("Pizza")
@ToString
public class Pizza extends MenuItem {
    @ManyToMany
    @JoinTable(name = "pizza_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "toppings_id"))
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public Pizza(String name, int calories, double price) {
        super(name, calories, price);
    }
    
    public Pizza(String name, int calories, double price, List<Topping> toppings) {
        super(name, calories, price);
        this.toppings = toppings;
    }

    public Pizza addTopping(Topping topping) {
        this.toppings.add(topping);
        return this;
    }
}
