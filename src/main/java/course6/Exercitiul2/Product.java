package course6.Exercitiul2;

import javax.validation.constraints.*;
public class Product {
    @NotNull
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
