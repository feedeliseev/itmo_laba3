package intefaces;

import objects.Object;

// Интерфейс для общих действий персонажей
public interface CharacterActions {
    String getName();    // Получить имя персонажа
    int getBravery();    // Получить уровень храбрости
    void flyOnSmt(Object o) throws Exception; // Попытка полета на шаре
}