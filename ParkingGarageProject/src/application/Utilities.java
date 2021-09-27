package application;

public class Utilities {
	
	public static String getTimeStamp(long recentTime, long previousTime) {
		String timeStampString = "";
		int seconds;
		int minutes;
		int hours;
		int days;
		
		long timeDuration = (recentTime - previousTime)/1000;
		
		days = (int)(timeDuration/(24*60*60));
		timeDuration %= (24*60*60);
		hours = (int)(timeDuration/(60*60));
		timeDuration %= (60*60);
		minutes = (int)(timeDuration/(60));
		timeDuration %= 60;
		seconds = (int)timeDuration;
		
		timeStampString = days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds";
		return timeStampString;
	}

}
