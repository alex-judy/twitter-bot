package BotTesting;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;


public class WeatherBot {

	private static String cons_key = "X0ynvmrxSDNYi8ebywxjrwqHD";
	private static String cons_secret = "kGImPYEpQWvu0qUKf8ND8wUb9NxyqChihZ8daB0xqFbcxzSDqS";
	private static String access_token = "849618273360650241-A0tGO0ciXqszIkXNc33NIyLXmiA8jCh";
	private static String access_token_secret = "cfTUlnK1glNzWH2xC33dW37J6t34lOyhZ8zMq0ntaefwC";
	
	public static Twitter configureBot(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(cons_key)
		  .setOAuthConsumerSecret(cons_secret)
		  .setOAuthAccessToken(access_token)
		  .setOAuthAccessTokenSecret(access_token_secret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		return twitter;
	}
	
	public static void main(String... args)
    {
		Twitter weatherTest = configureBot();
		try {
			Tweet("loumetrobot", "#louweather", weatherTest);
		} catch (TwitterException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
	
	public static void Tweet (String userName, String msg, Twitter weatherBot) throws TwitterException, InterruptedException 
	{
		String tweet = "@" + userName + " " + msg;
		
		try
		{
			if (tweet.length() <= 140)
			{		
				//Send the Tweet
				weatherBot.updateStatus(tweet);
			}
			else
			{
				//Parse string based on spaces and put the words into an array.
				String delims = "[ ]+";
				String[] tokens = msg.split(delims);
				//Setup new strings
				String newTweet = "";
				String newTweet2 = "..."; //Letting user know that this is from a previous tweet
				//If the new string in less then 100 characters, then add token and space
				//This way words stay intact during tweets
				for (String token : tokens)
				{
					if (newTweet.length() < 100)
						newTweet += token + " ";
					//Once over 100 characters, start new Tweet string
					else
						newTweet2 += token + " ";
				}
				
				//adding continuation at the end of tweet to let user know more tweets are coming.
				newTweet += "...";
				//Try sending new tweets
				Tweet(userName, newTweet, weatherBot);
				Tweet(userName, newTweet2, weatherBot);
			}
		}
		 catch (TwitterException tex)
        {
        	//WritingToFile.LogError(tex.getExceptionCode(), tex.getErrorMessage());
        	
        }
    	
    	catch (Exception ex)
    	{
    		//WritingToFile.LogError(ex.toString(), WritingToFile.exceptionStacktraceToString(ex));
    		//WritingToFile.CSVFile("InfoLog.csv", tweet, userName, "", "", "NOT SENT");
    	}
	}
	
	
}
