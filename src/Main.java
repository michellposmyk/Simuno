import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {
    public static void main (String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String dayName = now.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pl","PL"));
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(timeFormatter);
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedData = now.format(dataFormatter);
        System.out.println("Witaj w moim krolestwie.");
        System.out.println("Dzisiaj jest: " + dayName + " ("+ formattedData + ")");
        System.out.println("Aktualna godzina: "+ formattedTime);

        int hour = now.getHour();
        if (hour < 12) {
            System.out.println("Witaj, czas na 10 brzuszkow");
        } else if (hour < 18) {
            System.out.println("Jestes, teraz 5 brzuszkow");
        } else {
            System.out.println("Niezapomnij o 10 pompkach");
        }
    }

}
