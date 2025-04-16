public class DataValidator {

    private static String validateName(String name) {
        // Удаляем лишние пробелы и добавляем пробел между именем и фамилией
        name = name.replaceAll("\\s+", " ").trim();
        if (!name.matches("^[А-ЯЁа-яё]+ [А-ЯЁа-яё]+$")) {
            return "";
        }
        return name;
    }

}
