/**
 * 🧬 TOPIC: HIERARCHICAL INHERITANCE
 * 
 * Analogy: A Father has two sons. 
 * Both sons inherit the family name and house, but they have different hobbies.
 */

// 1. Parent Class
class Animal {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // A shared action every animal does
    void eat() {
        System.out.println(name + " 🍴 is eating...");
    }
}

// 2. Child 1 (Extends Animal)
class Dog extends Animal {
    void bark() {
        System.out.println(getName() + " 🐕 says: Woof! Woof!");
    }
}

// 3. Child 2 (Extends Animal)
class Cat extends Animal {
    void meow() {
        System.out.println(getName() + " 🐈 says: Meow! Meow!");
    }
}

public class HierarchicalDemo {
    public static void main(String[] args) {
        System.out.println("--- 🐾 ANIMAL KINGDOM DEMO ---");
        
        // Creating a Dog
        Dog myDog = new Dog();
        myDog.setName("Buddy");
        myDog.eat();  
        myDog.bark(); 
        
        // Creating a Cat
        Cat myCat = new Cat();
        myCat.setName("Kitty");
        myCat.eat();  
        myCat.meow(); 
        
        System.out.println("\n💡 LESSON: Multiple children can inherit from one parent!");
    }
}