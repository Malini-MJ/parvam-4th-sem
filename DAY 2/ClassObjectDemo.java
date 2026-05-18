// FILE: ClassObjectDemo.java
// TOPIC: What is a Class? What is an Object?
// CONCEPT: A class is a blueprint. An object is a real instance built from that blueprint.

// ── CLASS DEFINITION (the blueprint) ─────────────────────
class Teacher {

    // FIELDS: variables that store data for each object
    String name;   // teacher's name
    String dept;   // teacher's department
    String sub;    // subject taught

    // METHODS: actions the object can perform
    void teach() {
        System.out.println(name + " teaches " + sub);
    }

    void showInfo() {
        System.out.println("Name: " + this.name + ", Dept: " + this.dept + ", Subject: " + this.sub);
    }
}

// ── MAIN CLASS (where we use the blueprint) ─────────────
public class ClassObjectDemo {
    public static void main(String[] args) {

        // Create first Teacher object
        Teacher teach1 = new Teacher();
        teach1.name = "Laxmi";
        teach1.dept = "AIML";
        teach1.sub  = "Java";

        // Create second Teacher object
        Teacher teach2 = new Teacher();
        teach2.name = "Anya";
        teach2.dept = "CS";
        teach2.sub  = "Python";

        // Call methods on each object
        teach1.teach();       // Output: Laxmi teaches Java
        teach1.showInfo();    // Output: Name: Laxmi, Dept: AIML, Subject: Java

        teach2.teach();       // Output: Anya teaches Python
        teach2.showInfo();    // Output: Name: Anya, Dept: CS, Subject: Python
    }
}
