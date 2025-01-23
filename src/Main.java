import java.util.ArrayList;
import java.util.Random;
import objects.*;
import enums.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Создание региона
        Region forest = new Region("лес", "white sap");

        // Создание персонажей
        Random random = new Random();
        Znaika znaika = new Znaika(
                "Знайка",
                random.nextInt(3) + 1,  // Храбрость от 1 до 3
                Gender.MALE,
                random.nextInt(4) + 1   // Интеллект от 1 до 4
        );

        Korotishki korotishka = new Korotishki(
                "Коротышки",
                random.nextInt(3) + 1,  // Храбрость от 1 до 3
                random.nextInt(2) + 1   // Сила от 1 до 2
        );

        ArrayList<Balloon> balloons = new ArrayList<>();
        balloons.add(new Balloon("Запасной шар", 2, 0.2));
        balloons.add(new Balloon("Волшебный шар", 3, 0.3));
        balloons.add(new Balloon("Странный шар", 1, 0.1));

        // Попытка добычи резины
        try {
            forest = korotishka.extractRubber(forest); // Обновляем регион после добычи
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Balloon balloon = null;

        // Попытка построить шар
        try {
            forest = znaika.buildBalloon(forest); // Обновляем регион после использования ресурсов
            balloon = new Balloon("Воздушный шар", 3, 0.5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            znaika.trainBrain(); // Знайка тренируется, если не удалось построить
        }

        // Если шар не был построен, создаем резервный
        if (balloon == null) {
            balloon = new Balloon("Резервный шар", 3, 0.5);
        }

        // Полет на шаре
        if (balloon != null) {
            try {
                boolean isKorotishkaFlying = random.nextBoolean();

                if (isKorotishkaFlying) {
                    korotishka.flyOnSmt(balloon);
                } else {
                    znaika.flyOnSmt(balloon);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Проверка на падение шара
        try {
            balloon.checkFall();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Airship airship = null;

        // Попытка построить дирижабль
        try {
            znaika.buildAirship(); // Обновляем регион после использования ресурсов
            airship = new Airship("Дирижабль", 4, 0.5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Проверка на взрыв дирижабля
        if (airship != null) {
            try {
                airship.checkExplosion();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Проверка всех шаров в списке
        for (Balloon balloon1 : balloons) {
            try {
                balloon1.checkFall();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}