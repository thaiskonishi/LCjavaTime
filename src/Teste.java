import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Teste {

  public static void main(String[] args) {
    LocalDateTime data;
    String teste1 = "1985-12-11 12:10:33";
    Boolean b1 = teste1.matches("^[0-9]{4}.+[0-9]{2}$");
    System.out.println("b1 " + b1);

    String teste2 = "03:58:26 14-02-1983"; // "HH:mm:ss dd-MM-yyyy"
    Boolean b2 = teste2.matches("^?.+[0-9]{4}$");
    System.out.println("b2" + b2);

    String teste3 = "24-07-1988 23:02:41";
    Boolean b3 = teste3.matches("^\\d{2}-\\d{2}-\\d{4}.+?$");
    System.out.println("b3 " + b3);

    String teste4 = "08:03:07 1989-11-02";
    Boolean b4 = teste4.matches("^?.+\\d{4}-\\d{2}-\\d{2}");
    System.out.println("b4 " + b4);

    String testeString = "1985-12-11 12:10:33";
    if (testeString.matches("^[0-9]{4}.+[0-9]{2}$")) {
      data = LocalDateTime.parse(testeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      System.out.println(data);
    }

    LocalDateTime.parse("1985-12-11 12:10:33", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    DateTimeFormatter padrao = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    System.out.println("meu padrao: " + padrao.format(
        LocalDateTime.parse("1985-12-11 12:10:33", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
  }
}
