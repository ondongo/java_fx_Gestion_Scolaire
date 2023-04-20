package java_fx.core;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {


    public static boolean isEmail(String field){
        Pattern pattern=Pattern.compile("[a-zA-Z0-9]*@(gmail|yahoo|amed){1}(.com|.fr|.ngala){1}",Pattern.CASE_INSENSITIVE);
        // matcher===>verifier le motif
     Matcher matcher =pattern.matcher(field);
        return (matcher.find() && matcher.group().equals(field));
     } 
     public static boolean isNumber(String field){
        Pattern pattern=Pattern.compile("[0-9]*",Pattern.CASE_INSENSITIVE);
        Matcher matcher =pattern.matcher(field);
        return (matcher.find() && matcher.group().equals(field));




        
     } 
}

    

