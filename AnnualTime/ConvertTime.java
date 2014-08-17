import java.util.Calendar;
import java.math.*;
public class ConvertTime {
	// Constant declarations (in case you're using nonstandard days, or something)
	static MathContext mc = new MathContext(2, RoundingMode.DOWN);
	static BigDecimal DAYS_IN_A_YEAR = new BigDecimal(365);
	static BigDecimal HOURS_IN_A_DAY = new BigDecimal(24);
	static BigDecimal MINUTES_IN_AN_HOUR = new BigDecimal(60);
	static BigDecimal SECONDS_IN_A_MINUTE = new BigDecimal(60);
	
	// TODO: Refactor: More efficient from seconds up instead of years down (I think).
	
	/** Takes Calendar date, returns String of current time with year as base unit
	*/
	public static String BaseYear (Calendar original){
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
		
		// Precision: minute
		BigDecimal Minute = new BigDecimal(original.get(12));
		Minute = Minute.divide(MINUTES_IN_AN_HOUR, mc);
		Minute = Minute.divide(HOURS_IN_A_DAY, mc);
		Minute = Minute.divide(DAYS_IN_A_YEAR, mc);
		date = date.add(Minute);
		
		// Precision: second
		BigDecimal Second = new BigDecimal(original.get(13));
		Second = Second.divide(SECONDS_IN_A_MINUTE, mc);
		Second = Second.divide(MINUTES_IN_AN_HOUR, mc);
		Second = Second.divide(HOURS_IN_A_DAY, mc);
		Second = Second.divide(DAYS_IN_A_YEAR, mc);
		date = date.add(Second);

		// Alternate method. Produces different result.
//		BigDecimal time = new BigDecimal(original.get(13));
//		time = time.divide(SECONDS_IN_A_MINUTE, mc);
//		time = time.add(new BigDecimal(original.get(12)));
//		time = time.divide(MINUTES_IN_AN_HOUR, mc);
//		time = time.add(new BigDecimal(original.get(11)));
//		time = time.divide(HOURS_IN_A_DAY, mc);
//		time = time.add(new BigDecimal(original.get(6)));
//		time = time.divide(DAYS_IN_A_YEAR, mc);
//		
//		date = date.add(time);
		
		// Done
		return date.toPlainString();
	}
	
	/** Takes Calendar date, returns verbose String of current time with year as base unit
	 * Warning: Only compatible with dates after 1 BCE. May need revision for dates after 9999 CE.
	 */
	public static String LongBaseYear (Calendar original){
		String result;
		
		// >1 year units
		int time = original.get(1);
		result = (time/1000)+" Kiloyears, ";
		time = time - ((time/1000)*1000);
		result = result+(time/100)+" Hectoyears, ";
		time = time - ((time/100)*100);
		result = result+(time/10)+" Decayears, ";
		time = time - ((time/10)*10);
		result = result+time+" years, ";
		
		// Get <1 year data (copy/pasted from BaseYear):
		BigDecimal date = new BigDecimal(0);
		// Precision: day
		BigDecimal Dayofyear = new BigDecimal(original.get(6));
		Dayofyear = Dayofyear.divide(DAYS_IN_A_YEAR, mc);
		date = date.add(Dayofyear);
		
		// Precision: hour
		BigDecimal Hourofday = new BigDecimal(original.get(11));
		Hourofday = Hourofday.divide(HOURS_IN_A_DAY, mc);
		Hourofday = Hourofday.divide(DAYS_IN_A_YEAR, mc);
		date = date.add(Hourofday);
		
		// Precision: minute
		BigDecimal Minute = new BigDecimal(original.get(12));
		Minute = Minute.divide(MINUTES_IN_AN_HOUR, mc);
		Minute = Minute.divide(HOURS_IN_A_DAY, mc);
		Minute = Minute.divide(DAYS_IN_A_YEAR, mc);
		date = date.add(Minute);
		
		// Precision: second
		BigDecimal Second = new BigDecimal(original.get(13));
		Second = Second.divide(SECONDS_IN_A_MINUTE, mc);
		Second = Second.divide(MINUTES_IN_AN_HOUR, mc);
		Second = Second.divide(HOURS_IN_A_DAY, mc);
		Second = Second.divide(DAYS_IN_A_YEAR, mc);
		date = date.add(Second);
		
		date = date.scaleByPowerOfTen(1);
		result = result+date.intValue()+" Deciyears, ";
		/* Alright, hear me out:
		 * Due to how BigDecimals work, this part makes date = date-int(date/1)
		 */
		date = date.subtract(date.divideToIntegralValue(new BigDecimal(1)));
		date = date.scaleByPowerOfTen(1);
		result = result+date.intValue()+" Centiyears, ";
		date = date.subtract(date.divideToIntegralValue(new BigDecimal(1)));
		date = date.scaleByPowerOfTen(1);
		result = result+date.intValue()+" Milliyears, and ";
		date = date.subtract(date.divideToIntegralValue(new BigDecimal(1)));
		date = date.scaleByPowerOfTen(3);
		result = result+date.toPlainString()+" Microyears";
		
		return result;
	}
}
