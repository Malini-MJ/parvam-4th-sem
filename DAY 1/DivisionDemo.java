public class DivisionDemo {
    public static void main(String[] args) {
        int totalMarks = 450;
        int numberOfSubjects = 5;

        // Division gives the quotient
        int averageMarks = totalMarks / numberOfSubjects;

        // Modulus gives the remainder
        int remainder = totalMarks % numberOfSubjects;

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Number of Subjects: " + numberOfSubjects);
        System.out.println("Average Marks: " + averageMarks);
        System.out.println("Remainder when divided: " + remainder);
    }
}
