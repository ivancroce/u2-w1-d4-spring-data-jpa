package ictech.u2_w1_d4_spring_data_jpa.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Entity
@DiscriminatorValue("Drink")
@ToString
public class Drink extends MenuItem {

    public Drink(String name, int calories, double price) {
        super(name, calories, price);
    }
}
