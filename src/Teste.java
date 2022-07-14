import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Teste {
    
    public static void main(String[] args) {
        
      // \d{3}\.\d{3}\.\d{3}-\d{2}    "^\\d{4}.*"   ".*(?i)2XXX6.*"
    //   String testeString = "1985-12-11 12:10:33";
      String testeString = "03:58:26 14-02-1983";
      LocalDateTime data;
    //   Boolean b = testeString.matches("^[0-9]{4}.+[0-9]{2}$");
      Boolean b = testeString.matches("^?.+[0-9]{4}$");
      System.out.println(b);
      if (testeString.matches("^[0-9]{4}.+[0-9]{2}$")){
                              data = LocalDateTime.parse(testeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                  System.out.println(data);
      }
           

    }
}
