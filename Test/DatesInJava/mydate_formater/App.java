package mydate_formater;

import java.text.ParseException;
import java.text.SimpleDateFormat;

//Source : http://stackoverflow.com/questions/18589986/date-conversion-with-threadlocal

//Understand the use of ThreadLocal variable to overcome the shortcoming of DateFormater class which is not threadsafe.
class DateFormatter {

	private static ThreadLocal<SimpleDateFormat> outDateFormatHolder = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MM/dd/yyyy");
		}
	};

	private static ThreadLocal<SimpleDateFormat> inDateFormatHolder = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd");
		}
	};

	public static String formatDate(String date) throws ParseException {
		return outDateFormatHolder.get().format(
				inDateFormatHolder.get().parse(date));
	}
}

public class App {

	public static void main(String[] args) {
		try {
			String dateString = DateFormatter.formatDate("20141209");
			System.out.println("Date formatted in string is " + dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
