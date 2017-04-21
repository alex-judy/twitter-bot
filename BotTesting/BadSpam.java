package BotTesting;


import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.text.SimpleDateFormat;
import java.util.*;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class BadSpam {

	private static String cons_key = "5Cx49Ap2rSEyboBL2B94prlp7";
	private static String cons_secret = "p3vlyGkH2imbkyMozsJzLwsfc9Rh6756JHRhNjUvNusfyP759y";
	private static String access_token = "854813767720415234-A5U8xQ0DsvV75C8e3g3bFbBvCaFe0oC";
	private static String access_token_secret = "W4QnBu6nRHLRlyd1ZePvJAOhTq5RcSOJycyOjTBrbe0zo";

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

		Twitter badSpamTest = configureBot();
		
		int zip[] = new int[100]; //create array for zipcodes
		
		//random number generator parameters
		Random r = new Random();
		int Low = 10000;
		int High = 99999;

		//tweet 10 times
		for(int i = 0; i < 10; i++)
		{
			//fill int array with random numbers 
			zip[i] = (int)(r.nextInt(High-Low) + Low);
			
			//if the current element is included in 40000 to 49999 then go back and refill that element
			if(zip[i] > 40000 && zip[i] < 50000)
			{
				i--;
			}
			
			//if zip code is in accepted range then tweet
			else if(zip[i] < 40000 || zip[i] > 50000)
			{
				
				//create string to tweet
				String content = zip[i] +" #LouCrimeZip";
	
				try {
					Tweet("loumetrobot", content, badSpamTest);
					Thread.sleep(5000*60);
				} catch (TwitterException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			else
			{
				System.out.println("Something has gone wrong.");
			}

		}


	}
	
	
	public static void Tweet (String userName, String msg, Twitter badSpamTest) throws TwitterException, InterruptedException 
	{
		String tweet = "@" + userName + " " + msg;
		
		try
		{
			if (tweet.length() <= 140)
			{		
				//Send the Tweet
				Status status = badSpamTest.updateStatus(tweet);
		        
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
				Tweet(userName, newTweet, badSpamTest);
				Tweet(userName, newTweet2, badSpamTest);
			}
		}
		 catch (TwitterException tex)
        {
        	//WritingToFile.LogError(tex.getExceptionCode(), tex.getErrorMessage());
			 System.out.println(tex.getStatusCode() + " Bad Spam");
			 
        	
        }
    	
    	catch (Exception ex)
    	{
    		//WritingToFile.LogError(ex.toString(), WritingToFile.exceptionStacktraceToString(ex));
    		//WritingToFile.CSVFile("InfoLog.csv", tweet, userName, "", "", "NOT SENT");
    	}
	}

}

