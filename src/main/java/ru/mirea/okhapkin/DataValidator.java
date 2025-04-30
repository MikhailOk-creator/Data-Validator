public class DataValidator {

    public static String validateName(String name) {
        name = name.replaceAll("\\s+", " ").trim();
        if (!name.matches("^[А-ЯЁа-яё]+ [А-ЯЁа-яё]+$")) {
            return "";
        }
        return name;
    }

    public static String validateAge(String age) {
        age = age.replaceAll("[^0-9]", "");
        try {
            int ageNum = Integer.parseInt(age);
            if (ageNum < 0 || ageNum > 120) return "";
        } catch (NumberFormatException e) {
            return "";
        }
        return age;
    }

    public static String validatePhone(String phone) {
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

    public static String validateEmail(String email) {
        email = email.replaceAll("\\.{2,}", ".");
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return "";
        }
        return email;
    }

}
