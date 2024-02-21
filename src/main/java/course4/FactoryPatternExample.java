package course4;

// Abstract Factory
interface FurnitureFactory {
    Chair createChair();
    Table createTable();
}
// Concrete Factory
class OfficeFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new OfficeChair();
    }
    public Table createTable() {
        return new OfficeTable();
    }
}
// Concrete Factory
class HomeFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new HomeChair();
    }
    public Table createTable() {
        return new HomeTable();
    }
}
// Abstract Product
interface Chair {
    void sit();
}
// Concrete Product
class OfficeChair implements Chair {
    public void sit() {
        System.out.println("Sitting on an office chair.");
    }
}
// Concrete Product
class HomeChair implements Chair {
    public void sit() {
        System.out.println("Sitting on a home chair.");
    }
}
// Abstract Product
interface Table {
    void work();
}
// Concrete Product
class OfficeTable implements Table {
    public void work() {
        System.out.println("Working on an office table.");
    }
}
// Concrete Product
class HomeTable implements Table {
    public void work() {
        System.out.println("Working on a home table.");
    }
}
public class FactoryPatternExample {
    public static void main(String[] args) {


        FurnitureFactory home = new HomeFurnitureFactory();
        Chair chair = home.createChair();
        chair.sit();


        Table table = home.createTable();
        table.work();


        FurnitureFactory office = new OfficeFurnitureFactory();
        Chair chairOffice = office.createChair();
        chairOffice.sit();


        Table tableOffice = office.createTable();
        tableOffice.work();
    }
}

