package com.example.user.javacoretraining.collections;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see CollectionsBlockTest.
 */
public class CollectionsBlock<T extends Comparable> {

    /**
     * Даны два упорядоченных по убыванию списка.
     * Объедините их в новый упорядоченный по убыванию список.
     * Исходные данные не проверяются на упорядоченность в рамках данного задания
     *
     * @param firstList  первый упорядоченный по убыванию список
     * @param secondList второй упорядоченный по убыванию список
     * @return объединенный упорядоченный список
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask0(@NonNull List<T> firstList, @NonNull List<T> secondList) {
        List<T> mergedList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.size() && j < secondList.size()) {
            if (firstList.get(i).compareTo(secondList.get(j)) >= 0) {
                mergedList.add(firstList.get(i));
                i++;
            }
            else {
                mergedList.add(secondList.get(j));
                j++;
            }
        }
        if (i == firstList.size()) {
            mergedList.addAll(secondList.subList(j, secondList.size()));
        }
        else {
            mergedList.addAll(firstList.subList(i, firstList.size()));
        }
        return mergedList;
    }

    /**
     * Дан список. После каждого элемента добавьте предшествующую ему часть списка.
     *
     * @param inputList с исходными данными
     * @return измененный список
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask1(@NonNull List<T> inputList) {
        List<T> outputList = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            outputList.add(inputList.get(i));
            outputList.addAll(inputList.subList(0, i ));
        }
        return outputList;
    }

    /**
     * Даны два списка. Определите, совпадают ли множества их элементов.
     *
     * @param firstList  первый список элементов
     * @param secondList второй список элементов
     * @return <tt>true</tt> если множества списков совпадают
     * @throws NullPointerException если один из параметров null
     */
    public boolean collectionTask2(@NonNull List<T> firstList, @NonNull List<T> secondList) {
        Set<T> firstSet = new HashSet<>(firstList);
        Set<T> secondSet = new HashSet<>(secondList);
        return firstSet.equals(secondSet);
    }

    /**
     * Создать список из заданного количества элементов.
     * Выполнить циклический сдвиг этого списка на N элементов вправо или влево.
     * Если N > 0 циклический сдвиг вправо.
     * Если N < 0 циклический сдвиг влево.
     *
     * @param inputList список, для которого выполняется циклический сдвиг влево
     * @param n         количество шагов циклического сдвига N
     * @return список inputList после циклического сдвига
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask3(@NonNull List<T> inputList, int n) {
        if (inputList.isEmpty() || n == 0) {
            return inputList;
        }
        int size = inputList.size();
        int absN = Math.abs(n);
        if (absN > size) {
            absN = absN % size;
        }
        List<T> outputList = new ArrayList<>(size);
        if (n > 0) {
            outputList.addAll(inputList.subList(size - absN, size));
            outputList.addAll(inputList.subList(0, size - absN));
        }
        else {
            outputList.addAll(inputList.subList(absN, size));
            outputList.addAll(inputList.subList(0, absN));
        }
        return outputList;
    }

    /**
     * Элементы списка хранят слова предложения.
     * Замените каждое вхождение слова A на B.
     *
     * @param inputList список со словами предложения и пробелами для разделения слов
     * @param a         слово, которое нужно заменить
     * @param b         слово, на которое нужно заменить
     * @return список после замены каждого вхождения слова A на слово В
     * @throws NullPointerException если один из параметров null
     */
    public List<String> collectionTask4(@NonNull List<String> inputList, @NonNull String a,
                                        @NonNull String b) {
        List<String> outputList = new ArrayList<>();
        for (String element : inputList) {
            if (element.equals(a)) {
                outputList.add(b);
            } else {
                outputList.add(element);
            }
        }
        return outputList;
    }

    /*
      Задание подразумевает создание класса(ов) для выполнения задачи.

      Дан список студентов. Элемент списка содержит фамилию, имя, отчество, год рождения,
      курс, номер группы, оценки по пяти предметам. Заполните список и выполните задание.
      Упорядочите студентов по курсу, причем студенты одного курса располагались
      в алфавитном порядке. Найдите средний балл каждой группы по каждому предмету.
      Определите самого старшего студента и самого младшего студентов.
      Для каждой группы найдите лучшего с точки зрения успеваемости студента.
     */
    static final int MAX_GROUP = 2;
    public static List<Student> sortByCourseAndName(List<Student> inputList) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < inputList.size() - 1; i++) {
                Student current = inputList.get(i);
                Student next = inputList.get(i + 1);
                if (current.course == next.course) {
                    if (current.firstName.compareTo(next.firstName) > 0) {
                        inputList.set(i, next);
                        inputList.set(i + 1, current);
                        swapped = true;
                    }
                } else if (current.course > next.course) {
                    inputList.set(i, next);
                    inputList.set(i + 1, current);
                    swapped = true;
                }
            }
        }
        return inputList;
    }

    public static Map<Integer, Map<Subject, Double>> computeAverageGrade(List<Student> inputList) {
        Map<Integer, Map<Subject, Double>> averageGradeMap = new HashMap<>();
        for (int i = 1; i < MAX_GROUP + 1; i++) {
            Map<Subject, Double> subjectToGradeMap = new HashMap<>();
            int studentsCount = 0;
            for (Student student : inputList) {
                if (student.groupNumber == i) {
                    for (Subject subject : Subject.values()) {
                        if (subjectToGradeMap.get(subject) == null) {
                            subjectToGradeMap.put(subject, student.subjectGrades.get(subject).doubleValue());
                        } else {
                            subjectToGradeMap.put(subject, subjectToGradeMap.get(subject) +
                                    student.subjectGrades.get(subject).doubleValue());
                        }
                    }
                    studentsCount++;
                }
            }
            for (Subject subject: Subject.values()) {
                subjectToGradeMap.put(subject, subjectToGradeMap.get(subject) / studentsCount);
            }
            averageGradeMap.put(i, subjectToGradeMap);
        }
        return averageGradeMap;
    }

    public static Student findOldest(List<Student> inputList) {
        Student oldestStudent = inputList.get(0);
        for (Student student : inputList) {
            if (student.yearOfBirth < oldestStudent.yearOfBirth) {
                oldestStudent = student;
            }
        }
        return oldestStudent;
    }
    public static Student findYoungest(List<Student> inputList) {
        Student youngestStudent = inputList.get(0);
        for (Student student : inputList) {
            if (student.yearOfBirth > youngestStudent.yearOfBirth) {
                youngestStudent = student;
            }
        }
        return youngestStudent;
    }

    public static Map<Integer, Student> findBestStudent(List<Student> inputList) {
        Map<Integer, Student> groupToBestStudent = new HashMap<>();
        Student bestStudent = null;
        int maxGradeSum;
        int gradeSum;
        for (int i = 1; i < MAX_GROUP + 1; i++) {
            maxGradeSum = 0;
            for (Student student : inputList) {
                if (student.groupNumber != i) continue;
                gradeSum = 0;
                for (Subject subject : Subject.values()) {
                    gradeSum += student.subjectGrades.get(subject);
                }
                if (maxGradeSum < gradeSum) {
                    maxGradeSum = gradeSum;
                    bestStudent = student;
                };
            }
            groupToBestStudent.put(i, bestStudent);
        }
        return groupToBestStudent;
    }
}
class Student {
    Student(String firstName, String lastName,
            String patronymic, int yearOfBirth,
            int course, int groupNumber,
            HashMap<Subject,Integer> subjectGrades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.yearOfBirth = yearOfBirth;
        this.course = course;
        this.groupNumber = groupNumber;
        this.subjectGrades = subjectGrades;
    }
    String firstName;
    String lastName;
    String patronymic;
    int yearOfBirth;
    int course;
    int groupNumber;
    HashMap<Subject,Integer> subjectGrades;

}
class StudentListBuilder {
    List<String> names = Arrays.asList("James", "John","Robert", "Michael",
            "William", "David", "Richard", "Joseph", "Charles", "Thomas");
    Random random = new Random();
    public ArrayList<Student> getStudentsList(int listSize) {
        ArrayList<Student> studentsList = new ArrayList<>(listSize);

        for (int i = 0; i < listSize; i++) {
            HashMap<Subject,Integer> subjectGrades = new HashMap<>(5);
            for (Subject subject: Subject.values()) {
                subjectGrades.put(subject, random.nextInt(5) + 1);
            }
            studentsList.add(new Student(
                    names.get(random.nextInt(names.size())),
                    "M",
                    "J",
                    random.nextInt(41) + 1970,
                    random.nextInt(4) + 1,
                    random.nextInt(CollectionsBlock.MAX_GROUP) + 1,
                    subjectGrades
            ));
        }
        return studentsList;
    }
}
enum Subject { A,B,C,D,E }




