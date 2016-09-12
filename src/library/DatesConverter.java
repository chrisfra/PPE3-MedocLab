package library;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Classe de manipulation des dates
 * @author xavier
 *
 */
public abstract class DatesConverter {
	
	/**
	 * Méthode retournant la date du jour
	 * (les heures, minutes, secondes du GregorianCalendar seront positionnés à 0)
	 * @return la date du jour sous forme d'un GregorianCalendar
	 */
	public static GregorianCalendar today(){
		GregorianCalendar greg = new GregorianCalendar();
		return new GregorianCalendar(greg.get(Calendar.YEAR),greg.get(Calendar.MONTH),greg.get(Calendar.DATE));
//		return new GregorianCalendar();
	}
	
	/**
	 * Méthode de conversion d'une date en chaîne de caractères
	 * @param date la date à convertir sous forme d'un GregorianCalendar
	 * @return la date convertie au format String ("JJ-MM-AAAA")
	 */
	public static String dateToStringFR(GregorianCalendar date)	{
		if (date==null)
			return null;
		String dateFormat;
		dateFormat = String.valueOf(date.get(Calendar.DATE))+"-"+String.valueOf(date.get(Calendar.MONTH))+"-"+String.valueOf(date.get(Calendar.YEAR));
		return dateFormat;
	}
	
	/**
	 * Méthode de conversion d'une date en chaîne de caractères
	 * @param date la date à convertir sous forme d'un GregorianCalendar
	 * @return la date convertie au format String ("AAAA-MM-JJ")
	 */
	public static String dateToStringUS(GregorianCalendar date)	{
		if (date==null)
			return null;
		String dateFormat;
		dateFormat = String.valueOf(date.get(Calendar.YEAR))+"-"+String.valueOf(date.get(Calendar.MONTH))+"-"+String.valueOf(date.get(Calendar.DATE));
		return dateFormat;
	}
	
	/**
	 * Méthode de conversion d'une date en chaîne de caractères
	 * @param date la date à convertir sous forme d'un GregorianCalendar
	 * @return la date convertie au format String ("HH:MM")
	 */
	public static String hourToString(GregorianCalendar date)	{
		if (date==null)
			return null;
		String dateFormat;
		String h = String.valueOf(date.get(Calendar.HOUR_OF_DAY));
		if(date.get(Calendar.HOUR_OF_DAY)<10)
			h="0"+String.valueOf(date.get(Calendar.HOUR_OF_DAY));
		String m = String.valueOf(date.get(Calendar.MINUTE));
		if(date.get(Calendar.MINUTE)<10)
			m="0"+String.valueOf(date.get(Calendar.MINUTE));
		dateFormat = h+":"+m;
		return dateFormat;
	}
	
	/**
	 * Méthode de conversion d'une chaîne de caractères au format date
	 * @param strDate le String au format "JJ-MM-AAAA#HH:MM"
	 * @return le GregorianCalendar correspondant
	 */
	public static GregorianCalendar stringToDateHour(String strDate) {
		if (strDate==null)
			return null;
		String[] detailsDate, detailsHour, details;
		int year, month, day, hour, minute;
		details = strDate.split("#");
		detailsDate = details[0].split("-");
		detailsHour = details[1].split(":");
		year=Integer.parseInt(detailsDate[2]);
		month=Integer.parseInt(detailsDate[1]);
		day=Integer.parseInt(detailsDate[0]);
		hour=Integer.parseInt(detailsHour[0]);
		minute=Integer.parseInt(detailsHour[1]);
		return new GregorianCalendar(year,month,day,hour,minute);
	}
	
	/**
	 * Méthode de conversion d'une chaîne de caractères au format date
	 * @param strDate le String au format "JJ-MM-AAAA"
	 * @return le GregorianCalendar correspondant
	 */
	public static GregorianCalendar FRStringToDate(String strDate) {
		if (strDate==null)
			return null;
		String[] detailsDate;
		int year, month, day;
		detailsDate = strDate.split("-");
		year=Integer.parseInt(detailsDate[2]);
		month=Integer.parseInt(detailsDate[1]);
		day=Integer.parseInt(detailsDate[0]);
		return new GregorianCalendar(year,month,day);
	}
	
	/**
	 * Méthode de conversion d'une chaîne de caractères au format date
	 * @param strDate le String au format "AAAA-MM-JJ"
	 * @return le GregorianCalendar correspondant
	 */
	public static GregorianCalendar USStringToDate(String strDate) {
		if (strDate==null)
			return null;
		strDate = strDate.split(" ")[0];
		String[] detailsDate;
		int year, month, day;
		detailsDate = strDate.split("-");
		year=Integer.parseInt(detailsDate[0]);
		month=Integer.parseInt(detailsDate[1]);
		day=Integer.parseInt(detailsDate[2]);
		return new GregorianCalendar(year,month,day);
	}

//	/**
//	 * Méthode permettant de modifier les dimensions d'une image
//	 * @param source l'image à agrandir/retrecir
//	 * @param width la largeur voulue
//	 * @param height la hauteur voulue
//	 * @return l'image redimensionnée
//	 */
//	public static Image scaleImage(Image source, int width, int height) {
//	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//	    Graphics2D g = (Graphics2D) img.getGraphics();
//	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//	    g.drawImage(source, 0, 0, width, height, null);
//	    g.dispose();
//	    return img;
//	}
}
