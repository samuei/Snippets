import java.util.Calendar;
import java.math.*;
public class ConvertTime {
	static BigDecimal DAYS_IN_A_YEAR = new BigDecimal(365);
	static BigDecimal HOURS_IN_A_DAY = new BigDecimal(24);
	static BigDecimal MINUTES_IN_AN_HOUR = new BigDecimal(60);
	static BigDecimal SECONDS_IN_A_MINUTE = new BigDecimal(60);
	
	// TODO: Refactor: More efficient from seconds up instead of years down (I think).
	public static String BaseYear (Calendar original){
		MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
		// Precision: year
		BigDecimal date = new BigDecimal(original.get(1)); 
		
		// Precision: day
		BigDecimal Dayofyear = new BigDecimal(original.get(6));
		Dayofyear = Dayofyear.divide(DAYS_IN_A_YEAR, mc);
		date = date.add(Dayofyear);
		
		// Precision: hour
		BigDecimal Hourofday = new BigDecimal(original.get(11));
		Hourofday = Hourofday.divide(HOURS_IN_A_DAY, mc);
		Hourofday = Hourofday.divide(DAYS_IN_A_YEAR, mc);
		date = date.add(Hourofday);
		
		//Precision: minute
		BigDecimal Minute = new BigDecimal(original.get(12));
		Minute = Minute.divide(MINUTES_IN_AN_HOUR, mc);
		Minute = Minute.divide(HOURS_IN_A_DAY, mc);
		Minute = Minute.divide(DAYS_IN_A_YEAR, mc);
		date = date.add(Minute);
		
		//Precision: second
		BigDecimal Second = new BigDecimal(original.get(13));
		Second = Second.divide(SECONDS_IN_A_MINUTE, mc);
		Second = Second.divide(MINUTES_IN_AN_HOUR, mc);
		Second = Second.divide(HOURS_IN_A_DAY, mc);
		Second = Second.divide(DAYS_IN_A_YEAR, mc);
		date = date.add(Second);
		
		return date.toPlainString();
	}
}
