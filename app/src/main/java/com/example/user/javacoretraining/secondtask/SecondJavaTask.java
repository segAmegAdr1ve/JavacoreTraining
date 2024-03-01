package com.example.user.javacoretraining.secondtask;

import static com.example.user.javacoretraining.secondtask.Directions.*;

import android.graphics.Point;


public class SecondJavaTask {
    // простое лямбда-выражение
    Runnable myClosure = () -> System.out.println("I love Java");
    // функция, которая будет запускать заданное лямбда-выражение заданное количество раз.
    public static void repeatTask (int times, Runnable task) {
        for (int i = 0; i < times; i++) {
            task.run();
        }
    }

    // метод, принимающий координаты и одно из направлений
    // и возвращающий координаты после перехода по направлению
    public static Point move(Point point, Directions direction) {
        switch (direction) {
            case UP:
                point.y++;
                break;
            case DOWN:
                point.y--;
                break;
            case LEFT:
                point.x--;
                break;
            case RIGHT:
                point.x++;
                break;
        }
        return point;
    }
    // метод, осуществляющий несколько переходов от первоначальных координат
    // и выводящий координаты после каждого перехода.
    public static void printMultipleMove() {
        Point location = new Point(0, 0);
        Directions[] directions = {UP, UP, LEFT, DOWN, LEFT, DOWN, DOWN, RIGHT, RIGHT, DOWN, RIGHT};
        for (Directions direction : directions) {
            System.out.println(move(location, direction));
        }
    }
}
enum Directions {
    UP, DOWN, LEFT, RIGHT
}

interface Shape {
    double perimeter();
    double area();
}

class Rectangle implements Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double perimeter() {
        return (width + length) * 2;
    }

    @Override
    public double area() {
        return width * length;
    }
}

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return side * 4;
    }

    @Override
    public double area() {
        return side * side;
    }
}

class Circle implements Shape {
    private double diameter;

    public Circle(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public double perimeter() {
        return Math.PI * diameter;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(diameter / 2, 2);
    }
}

