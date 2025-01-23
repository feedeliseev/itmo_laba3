package objects;

public record Region(String name, String availableResources) {
    // Метод для обновления ресурсов
    public Region withUpdatedResources(String newResources) {
        return new Region(name, newResources);
    }
}