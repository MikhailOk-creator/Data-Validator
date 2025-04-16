public class DataValidator {

    private static String validateName(String name) {
        // Удаляем лишние пробелы и добавляем пробел между именем и фамилией
        name = name.replaceAll("\\s+", " ").trim();
        if (!name.matches("^[А-ЯЁа-яё]+ [А-ЯЁа-яё]+$")) {
            return "";
        }
        return name;
    }

    private static String validateAge(String age) {
        // Удаляем все нецифровые символы
        age = age.replaceAll("[^0-9]", "");
        try {
            int ageNum = Integer.parseInt(age);
            if (ageNum < 0 || ageNum > 120) return "";
        } catch (NumberFormatException e) {
            return "";
        }
        return age;
    }

}
