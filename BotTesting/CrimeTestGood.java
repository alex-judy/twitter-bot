package BotTesting;


import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.text.SimpleDateFormat;
import java.util.*;
import twitter4j.*;


public class CrimeTestGood{

	private static String cons_key = "hIN0aeqFgm7Du9fr9rGfMALzS";
	private static String cons_secret = "VkmwL2QTZnTRjjeQar9PNkGO45V6WgakRUtDg5xRlGAwiBnGQh";
	private static String access_token = "849774268212813824-5Hjunn4EvD5WLYY3QewVweveS3lJ4Gt";
	private static String access_token_secret = "AbAAn8NShGJZ01B84cF5QlPfotfzyDhwno3R8oswx8qId";

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

		Twitter goodCrimeTest = configureBot();

		int min = 0;

		//configure list
		List<String> list = new ArrayList<String>();

		//populate list with valid zip codes in KY
		list.add("40118");
		list.add("40201");
		list.add("40203");
		list.add("40202");
		list.add("40205");
		list.add("40118");
		list.add("40201");
		list.add("40203");
		list.add("40204");
		list.add("40207");
		list.add("40299");
		list.add("40223");
		list.add("40257");
		list.add("40291");
		list.add("40214");
		list.add("40218");

		String zipCode = list.get(new Random().nextInt(list.size()));

		//create string to tweet
		String content = zipCode +" #LouCrimeZip";
		
		try {
			Tweet("loumetrobot", content, goodCrimeTest);
		} catch (TwitterException | InterruptedException e) {
			e.printStackTrace();
		}


	}


	public static void Tweet (String userName, String msg, Twitter goodCrimeTest) throws TwitterException, InterruptedException 
	{
		String tweet = "@" + userName + " " + msg;

		try
		{
			if (tweet.length() <= 140)
			{		
				//Send the Tweet
				Status status = goodCrimeTest.updateStatus(tweet);

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
				Tweet(userName, newTweet, goodCrimeTest);
				Tweet(userName, newTweet2, goodCrimeTest);
			}
		}
		catch (TwitterException tex)
		{
			//WritingToFile.LogError(tex.getExceptionCode(), tex.getErrorMessage());
			 System.out.println(tex.getStatusCode() + " Good One Tweet");


		}

		catch (Exception ex)
		{
			//WritingToFile.LogError(ex.toString(), WritingToFile.exceptionStacktraceToString(ex));
			//WritingToFile.CSVFile("InfoLog.csv", tweet, userName, "", "", "NOT SENT");
		}
	}

}

