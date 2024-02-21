package course4;

// Clasa de produs
class Product {
    private String property1;
    private String property2;
    // Alte proprietăți
    private Product(Builder builder) {
        this.property1 = builder.property1;
        this.property2 = builder.property2;
        // Inițializarea altor proprietăți
    }

    public String getProperty1() {
        return property1;
    }

    public String getProperty2() {
        return property2;
    }

    // Metode getter
    // Metodele de obținere a valorilor
    // Builder intern
    static class Builder {
        private String property1;
        private String property2;
        // Alte proprietăți
        public Builder setProperty1(String property1) {
            this.property1 = property1;
            return this;
        }
        public Builder setProperty2(String property2) {
            this.property2 = property2;
            return this;
        }
        // Metoda pentru construirea obiectului
        public Product build() {
            return new Product(this);
        }
    }
}
// Utilizare
public class BuilderPattern {
    public static void main(String[] args) {
        Product product = new Product.Builder()
                .setProperty1("value1")
                .setProperty2("value2")
                .build();
        System.out.println(product.getProperty1() + " " + product.getProperty2());

    }
}