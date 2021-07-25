package com.amitph.java.streams.sort;

import com.amitph.java.streams.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortCollections {
    private List<Student> students;

    public void initialize() {
        Student student1 = new Student(2L, "Karl", "F", 18);
        Student student2 = new Student(3L, "Jack", "P", 20);
        Student student3 = new Student(5L, "Nick", "G", 17);
        Student student4 = new Student(1L, "Tom", "F", 21);
        Student student5 = new Student(4L, "Jon", "W", 22);

        students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
    }

    public void usingAnonymousComparator() {
        System.out.println("Soring by usingAnonymousComparator ");

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });

        students.forEach(System.out::println);
    }

    public void usingLambdaExpression() {
        System.out.println("Sorting by usingAnonymousComparator");

        students.sort(
                (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));

        students.forEach(System.out::println);
    }

    public void usingMethodReference() {
        System.out.println("Sorting by usingMethodReference");

        students.sort(StudentSortUtils::comparingFirstName);

        students.forEach(System.out::println);
    }

    public void usingComparatorComparing() {
        System.out.println("Sorting by usingComparatorComparing");

        students.sort(Comparator.comparing(Student::getAge));

        students.forEach(System.out::println);
    }

    public void usingComparatorCompositions() {
        System.out.println("Sorting by usingComparatorCompositions");

        students.sort(
                Comparator.comparing(Student::getLastName)
                        .thenComparing(Student::getFirstName)
        );

        students.forEach(System.out::println);
    }

    public void usingLambdaExpression_Reversed() {
        System.out.println("Sorting by usingLambdaExpression_Reversed");

        students.sort(
                (o1, o2) -> o2.getFirstName().compareTo(o1.getFirstName()));

        students.forEach(System.out::println);
    }

    public void usingComparatorComparing_Reversed() {
        System.out.println("Sorting by usingComparatorComparing_Reversed");

        students.sort(Comparator.comparing(
                Student::getAge,
                Comparator.reverseOrder()));

        students.forEach(System.out::println);
    }

    public static void main(String[] a) {
        SortCollections sortCollections = new SortCollections();
        sortCollections.initialize();

        sortCollections.usingAnonymousComparator();
        sortCollections.usingLambdaExpression();
        sortCollections.usingMethodReference();
        sortCollections.usingComparatorComparing();
        sortCollections.usingComparatorCompositions();
        sortCollections.usingLambdaExpression_Reversed();
        sortCollections.usingComparatorComparing_Reversed();
    }
}