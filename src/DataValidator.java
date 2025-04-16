public class DataValidator {

    private static String validateName(String name) {
        name = name.replaceAll("\\s+", " ").trim();
        if (!name.matches("^[А-ЯЁа-яё]+ [А-ЯЁа-яё]+$")) {
            return "";
        }
        return name;
    }

    private static String validateAge(String age) {
        age = age.replaceAll("[^0-9]", "");
        try {
            int ageNum = Integer.parseInt(age);
            if (ageNum < 0 || ageNum > 120) return "";
        } catch (NumberFormatException e) {
            return "";
        }
        return age;
    }

    private static String validatePhone(String phone) {
        String digits = phone.replaceAll("[^0-9]", "");

        if (digits.length() == 11 && digits.startsWith("7")) {
            return String.format("+7 (%s) %s-%s-%s",
                    digits.substring(1, 4),
                    digits.substring(4, 7),
                    digits.substring(7, 9),
                    digits.substring(9));
        }

        if (digits.length() >= 10 && digits.length() <= 15) {
            return "+" + digits;
        }

        return "";
    }

}
