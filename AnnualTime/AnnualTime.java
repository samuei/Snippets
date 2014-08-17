import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* Metric Time explicitly refers to using seconds as the base unit.
 * Decimal Time refers to using the day as the base unit.
 * Thus, Annual Time is going to refer to using the year as the base unit.
 */
public class AnnualTime {

	public static void main(String[] args) {
			
		   //get current date time with Calendar()
		   Calendar cal = Calendar.getInstance();
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   
		   System.out.println("The current time is "+dateFormat.format(cal.getTime())+".");
		   System.out.println("If the base unit were years, the current date and time would be "+ConvertTime.BaseYear(cal)+".");
		   System.out.println("Or, broken into units: "+ConvertTime.LongBaseYear(cal)+".");
		   // Year = 1, DoY = 6, HoD = 11, mm = 12, ss = 13, ms = 14
	}

}
