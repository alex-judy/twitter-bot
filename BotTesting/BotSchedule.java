package BotTesting;

import java.util.*;

public class BotSchedule {
	
	private static class Schedule extends TimerTask
	{
		public void run()
		{
    
    //call each bot
			CrimeTestGood.main();
			CrimeGoodSpam.main();
			BadSpam.main();
			BadRequestBot.main();
			WeatherBot.main();
		}
	}

	
	public static void main(String[] args) {
		
		Timer timer = new Timer();
	
		timer.schedule(new Schedule(), 1000, 1000*60*60); //run every hour, one sec delay
		System.out.println("Tweeting!"); //print every time it runs
	}

}
