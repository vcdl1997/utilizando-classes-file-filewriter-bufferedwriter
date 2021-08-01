package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = sdf.parse("30/07/2021");
		Date d2 = sdf.parse("01/08/2021");
		Long diff = d2.getTime() - d1.getTime();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(diff);
		
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); //Diferença em dias
	}
}
