package course4;
/*
Implementarea Factory Pattern pentru crearea unor tipuri de forme geometrice

Cerință: Implementați un Factory Pattern pentru a crea obiecte reprezentând diverse forme geometrice cum ar fi cerc,
pătrat și triunghi.


!!! Sa apara triangle inainte de circle fara sa modific main, folosind ASPECTE GS sau Threads, fara timeout
 */
public class FactoryPatternExercise {
    public static void main(String[] args) {
        Shapes circle = ShapesFactory.createShapes("circle");
        Shapes square = ShapesFactory.createShapes("square");
        Shapes triangle = ShapesFactory.createShapes("triangle");
        circle.create();
        square.create();
        triangle.create();
    }
}
interface Shapes {
    void create();
}
class Circle implements Shapes{
    public void create(){
        System.out.println("I will create a circle");
    }
}

class Square implements Shapes{
    public void create(){
        System.out.println("I will create a square");
    }
}
class Triangle implements Shapes{
    public void create(){
        System.out.println("I will create a triangle");
    }
}
class ShapesFactory{
    public static Shapes createShapes(String type) {
        return switch (type){
            case "circle" -> new Circle();
            case "square" -> new Square();
            case "triangle" -> new Triangle();
            default -> throw new IllegalArgumentException("Invalid shapes type");
        };
    }
}