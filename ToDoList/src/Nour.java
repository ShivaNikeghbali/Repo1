import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Nour
{
    public static void main(String[] args)
    {
        // covert string to local date
        String dateString = "22-02-2009";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);

        // print the local date using their (local date developer) format
        System.out.println(localDate);

        // convert localdate to string of my own format
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM-----yyyy");
        String stringDate2 = formatter2.format(localDate);
        System.out.println(stringDate2);


    }
}
