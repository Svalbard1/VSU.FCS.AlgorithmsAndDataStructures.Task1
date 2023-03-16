import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SolarSystem extends JPanel {
    private List<Planet> planets = new ArrayList<>();
    private Timer timer;
    private int delay = 10;

    public SolarSystem() {
        setPreferredSize(new Dimension(600, 400));

        // добавляем планеты
        planets.add(new Planet("Меркурий", 0.387, 88, 2439.7));
        planets.add(new Planet("Венера", 0.723, 225, 6051.8));
        planets.add(new Planet("Земля", 1, 365, 6371));
        planets.add(new Planet("Марс", 1.124, 687, 3389.5));
        planets.add(new Planet("Юпитер", 2.203, 4333, 69911));
        planets.add(new Planet("Сатурн", 4.537, 10759, 58232));
        planets.add(new Planet("Уран", 6.191, 30687, 25362));
        planets.add(new Planet("Нептун", 9.069, 60190, 24622));

        // запускаем таймер для обновления экрана
        timer = new Timer(delay, e -> repaint());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // рисуем солнце
        g2d.setColor(Color.yellow);
        g2d.fillOval(getWidth() / 2 - 25, getHeight() / 2 - 25, 50, 50);

        // рисуем планеты
        for (Planet planet : planets) {
            double x = getWidth() / 2 + planet.getDistance() * Math.cos(Math.toRadians(planet.getAngle()));
            double y = getHeight() / 2 + planet.getDistance() * Math.sin(Math.toRadians(planet.getAngle()));
            int size = (int) planet.getDiameter() / 500; // диаметр планеты в км, деленный на 1000 для масштаба
            g2d.setColor(planet.getColor());
            g2d.fillOval((int) x - size / 2, (int) y - size / 2, size, size);

            // обновляем угол планеты для следующего шага таймера
            planet.setAngle(planet.getAngle() + planet.getSpeed());
        }
    }
}

