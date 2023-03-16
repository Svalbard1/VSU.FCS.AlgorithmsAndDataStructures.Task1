import java.awt.*;

public class Planet  {
    private String name;
    private double distance; // в а.е.
    private int speed; // в днях
    private double diameter; // в км
    private int angle; // текущий угол поворота в градусах
    private Color color;

    public Planet(String name, double distance, int speed, double diameter) {
        this.name = name;
        this.distance = distance;
        this.speed = speed;
        this.diameter = diameter;
        // генерируем случайный цвет для планеты
        this.color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance * 100; // переводим в км
    }

    public int getSpeed() {
        return speed;
    }

    public double getDiameter() {
        return diameter;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle % 360; // ограничиваем угол поворота от 0 до 359 градусов
    }

    public Color getColor() {
        return color;
    }
}
