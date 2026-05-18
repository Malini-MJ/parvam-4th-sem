/**
 * 🔄 TOPIC: METHOD OVERRIDING (PREVIEW)
 * 
 * Analogy: A Parent has a 'Car' but it's an old model.
 * The Child inherits the 'Car' but they paint it red and upgrade the engine.
 * They "Overrode" the parent's version with their own.
 */

// 1. Parent Class
class Shape {
    private String color = "Black";

    public String getColor() { return color; }

    void draw() {
        System.out.println("✏️ Drawing a generic " + color + " shape...");
    }
}

// 2. Child 1 (Changes the draw method)
class Circle extends Shape {
    // 🔄 We 'Override' the parent's draw() method
    @Override
    void draw() {
        System.out.println("✏️ Drawing a beautiful CIRCLE ⭕");
    }
}

// 3. Child 2 (Changes the draw method differently)
class Square extends Shape {
    @Override
    void draw() {
        System.out.println("✏️ Drawing a perfect SQUARE ⬜");
    }
}

public class OverridingPreview {
    public static void main(String[] args) {
        System.out.println("--- 🎨 SHAPE DRAWING SYSTEM ---");
        
        Shape s1 = new Circle(); // Circle is a Shape
        Shape s2 = new Square(); // Square is a Shape
        
        s1.draw(); // Calls the Circle version (Overridden)
        s2.draw(); // Calls the Square version (Overridden)
        
        System.out.println("\n💡 LESSON: Overriding allows children to give their own version of a parent's action.");
    }
}