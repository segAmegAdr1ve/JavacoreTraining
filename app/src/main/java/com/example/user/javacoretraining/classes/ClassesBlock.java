package com.example.user.javacoretraining.classes;

import android.graphics.Point;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Набор заданий по работе с классами в java.
 * <p>
 * Задания подразумевают создание класса(ов), выполняющих задачу.
 * <p>
 * Проверка осуществляется ментором.
 */
public interface ClassesBlock {

    /*
      I

      Создать класс с двумя переменными. Добавить функцию вывода на экран
      и функцию изменения этих переменных. Добавить функцию, которая находит
      сумму значений этих переменных, и функцию, которая находит наибольшее
      значение из этих двух переменных.
     */
    class First {
        private int a = 0;
        private int b = 0;
        public void setA(int a) {
            this.a = a;
        }
        public void setB(int b) {
            this.b = b;
        }
        public void printA() {
            System.out.println(a);
        }
        public void printB() {
            System.out.println(b);
        }
        public int sumAB() {
            return a + b;
        }
        public int getMax() {
            return Math.max(a, b);
        }
    }

    /*
      II

      Создать класс, содержащий динамический массив и количество элементов в нем.
      Добавить конструктор, который выделяет память под заданное количество элементов.
      Добавить методы, позволяющие заполнять массив случайными числами,
      переставлять в данном массиве элементы в случайном порядке, находить количество
      различных элементов в массиве, выводить массив на экран.
     */
    class Second {
        Second(int arrayCapacity) {
            intArray = new ArrayList<>(arrayCapacity);
            this.arrayCapacity = arrayCapacity;
        }
        ArrayList<Integer> intArray;
        int arrayCapacity;
        public void fillRandom() {
            Random random = new Random();
            for (int i = 0; i < arrayCapacity; i++) {
                intArray.add(random.nextInt());
            }
        }
        public void shuffleArray() {
            Collections.shuffle(intArray);
        }
        public int occurrenceNumber(int value) {
            int count = 0;
            for (int num : intArray) {
                if (num == value) {
                    count++;
                }
            }
            return count;
        }
        public void printArray() {
            System.out.println(intArray);
        }
    }

    /*
      III

      Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
      вычисления площади, периметра и точки пересечения медиан.
      Описать свойства для получения состояния объекта.
     */
    class Triangle {
        private Point vertex1;
        private Point vertex2;
        private Point vertex3;

        public Triangle(Point vertex1, Point vertex2, Point vertex3) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.vertex3 = vertex3;
        }

        private double sideLength(Point p1, Point p2) {
            return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
        }

        public double calculatePerimeter() {
            double side1 = sideLength(vertex1, vertex2);
            double side2 = sideLength(vertex2, vertex3);
            double side3 = sideLength(vertex3, vertex1);
            return side1 + side2 + side3;
        }

        public double calculateArea() {
            double side1 = sideLength(vertex1, vertex2);
            double side2 = sideLength(vertex2, vertex3);
            double side3 = sideLength(vertex3, vertex1);
            double s = (side1 + side2 + side3) / 2;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }

        public Point centroid() {
            int x = (vertex1.x + vertex2.x + vertex3.x) / 3;
            int y = (vertex1.y + vertex2.y + vertex3.y) / 3;
            return new Point(x, y);
        }

        public Point getVertex1() {
            return vertex1;
        }

        public void setVertex1(Point vertex1) {
            this.vertex1 = vertex1;
        }

        public Point getVertex2() {
            return vertex2;
        }

        public void setVertex2(Point vertex2) {
            this.vertex2 = vertex2;
        }

        public Point getVertex3() {
            return vertex3;
        }

        public void setVertex3(Point vertex3) {
            this.vertex3 = vertex3;
        }
    }

    /*
      IV

      Составить описание класса для представления времени.
      Предусмотреть возможности установки времени и изменения его отдельных полей
      (час, минута, секунда) с проверкой допустимости вводимых значений.
      В случае недопустимых значений полей выбрасываются исключения.
      Создать методы изменения времени на заданное количество часов, минут и секунд.
     */
    class Time {
        private int hour;
        private int minute;
        private int second;

        public Time(int hour, int minute, int second) {
            setHour(hour);
            setMinute(minute);
            setSecond(second);
        }

        public void setHour(int hour) {
            if (hour >= 0 && hour < 24) {
                this.hour = hour;
            } else {
                throw new IllegalArgumentException("Недопустимое значение для часа");
            }
        }

        public void setMinute(int minute) {
            if (minute >= 0 && minute < 60) {
                this.minute = minute;
            } else {
                throw new IllegalArgumentException("Недопустимое значение для минуты");
            }
        }

        public void setSecond(int second) {
            if (second >= 0 && second < 60) {
                this.second = second;
            } else {
                throw new IllegalArgumentException("Недопустимое значение для секунды");
            }
        }

        public void addHours(int hours) {
            int newHour = (this.hour + hours) % 24;
            setHour(newHour);
        }

        public void addMinutes(int minutes) {
            int totalMinutes = this.hour * 60 + this.minute + minutes;
            setHour((totalMinutes / 60) % 24);
            setMinute(totalMinutes % 60);
        }

        public void addSeconds(int seconds) {
            int totalSeconds = this.hour * 3600 + this.minute * 60 + this.second + seconds;
            setHour((totalSeconds / 3600) % 24);
            setMinute((totalSeconds / 60) % 60);
            setSecond(totalSeconds % 60);
        }
    }


    /*
      V

      Класс Абонент: Идентификационный номер, Фамилия, Имя, Отчество, Адрес,
      Номер кредитной карточки, Дебет, Кредит, Время междугородных и городских переговоров;
      Конструктор; Методы: установка значений атрибутов, получение значений атрибутов,
      вывод информации. Создать массив объектов данного класса.
      Вывести сведения относительно абонентов, у которых время городских переговоров
      превышает заданное.  Сведения относительно абонентов, которые пользовались
      междугородной связью. Список абонентов в алфавитном порядке.
     */
    class Abonent implements Comparable<Abonent> {
        private int id;
        private String lastName;
        private String firstName;
        private String patronymic;
        private String address;
        private String creditCardNumber;
        private int intercityCallTime;
        private int localCallTime;

        public Abonent(int id, String lastName, String firstName, String patronymic, String address, String creditCardNumber, int intercityCallTime, int localCallTime) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.patronymic = patronymic;
            this.address = address;
            this.creditCardNumber = creditCardNumber;
            this.intercityCallTime = intercityCallTime;
            this.localCallTime = localCallTime;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setPatronymic(String middleName) {
            this.patronymic = middleName;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCreditCardNumber(String creditCardNumber) {
            this.creditCardNumber = creditCardNumber;
        }

        public void setIntercityCallTime(int intercityCallTime) {
            this.intercityCallTime = intercityCallTime;
        }

        public void setLocalCallTime(int localCallTime) {
            this.localCallTime = localCallTime;
        }

        public int getId() {
            return id;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getPatronymic() {
            return patronymic;
        }

        public String getAddress() {
            return address;
        }

        public String getCreditCardNumber() {
            return creditCardNumber;
        }

        public int getIntercityCallTime() {
            return intercityCallTime;
        }

        public int getLocalCallTime() {
            return localCallTime;
        }

        public void printInfo() {
            System.out.println("ID: " + id);
            System.out.println("Фамилия: " + lastName);
            System.out.println("Имя: " + firstName);
            System.out.println("Отчество: " + patronymic);
            System.out.println("Адрес: " + address);
            System.out.println("Номер кредитной карточки: " + creditCardNumber);
            System.out.println("Время междугородных переговоров: " + intercityCallTime + " минут");
            System.out.println("Время городских переговоров: " + localCallTime + " минут");
        }
        public static Abonent[] createAbonentArray(int size) {
            Abonent[] abonents = new Abonent[size];
            for (int i = 0; i < size; i++) {
                abonents[i] = new Abonent(
                        i + 1,
                        "Фамилия" + i,
                        "Имя" + i,
                        "Отчество" + i,
                        "Адрес" + i,
                        "Карта" + i,
                        100 + i,
                        200 + i
                );
            }
            return abonents;
        }
        public static void printOvertime(Abonent[] abonents, int topBound) {
            for (Abonent abonent : abonents) {
                if (abonent.localCallTime > topBound) {
                    abonent.printInfo();
                }
            }
        }

        public static void printIntercityCallUsers(Abonent[] abonents) {
            for (Abonent abonent : abonents) {
                if (abonent.intercityCallTime > 0) {
                    abonent.printInfo();
                }
            }
        }

        public static void sortAbonentsByName(Abonent[] abonents) {
            Arrays.sort(abonents);
        }

        @Override
        public int compareTo(@NonNull Abonent abonent) {
            return this.firstName.compareTo(abonent.firstName);
        }
    }

    /*
      VI

      Задача на взаимодействие между классами. Разработать систему «Вступительные экзамены».
      Абитуриент регистрируется на Факультет, сдает Экзамены. Преподаватель выставляет Оценку.
      Система подсчитывает средний бал и определяет Абитуриента, зачисленного в учебное заведение.
     */
    class Applicant {
        private String name;
        private List<Integer> examScores;

        public Applicant(String name) {
            this.name = name;
            this.examScores = new ArrayList<>();
        }

        public void addExamScore(int score) {
            examScores.add(score);
        }

        public double calculateAverageScore() {
            int sum = 0;
            for (int score : examScores) {
                sum += score;
            }
            return (double) sum / examScores.size();
        }

        public String getName() {
            return name;
        }
    }

    class Teacher {
        public void assignScore(Applicant applicant, int score) {
            applicant.addExamScore(score);
        }
    }

    class Faculty {
        private List<Applicant> applicants;

        public Faculty() {
            this.applicants = new ArrayList<>();
        }

        public void registerApplicant(Applicant applicant) {
            applicants.add(applicant);
        }

        public void enrollStudents() {
            for (Applicant applicant : applicants) {
                if (applicant.calculateAverageScore() >= 60) {
                    System.out.println("Студент " + applicant.getName() + " зачислен");
                } else {
                    System.out.println("Студент " + applicant.getName() + " не зачислен");
                }
            }
        }
    }

    /*
      VII

      Задача на взаимодействие между классами. Разработать систему «Интернет-магазин».
      Товаровед добавляет информацию о Товаре. Клиент делает и оплачивает Заказ на Товары.
      Товаровед регистрирует Продажу и может занести неплательщика в «черный список».
     */
    class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    class Order {
        private List<Product> products;
        private double totalPrice;

        public Order() {
            this.products = new ArrayList<>();
            this.totalPrice = 0;
        }

        public void addProduct(Product product) {
            products.add(product);
            totalPrice += product.getPrice();
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public List<Product> getProducts() {
            return products;
        }
    }

    class Salesperson {
        private List<String> blackList;

        public Salesperson() {
            this.blackList = new ArrayList<>();
        }

        public void registerSale(Order order) {
            System.out.println("Продажа на: " + order.totalPrice + " зарегистрирована");
        }

        public void addToBlackList(String customer) {
            blackList.add(customer);
        }
    }

    class Client {
        public void makeOrder(Order order, Salesperson salesperson) {
            salesperson.registerSale(order);
        }
    }
}
