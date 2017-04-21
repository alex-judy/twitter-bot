package BotTesting;


import twitter4j.conf.ConfigurationBuilder;

import java.util.*;
import twitter4j.*;


public class CrimeGoodSpam{

	private static String cons_key = "jPtnEaGACM7ZFQ1Kq42pvsV8e";
	private static String cons_secret = "n3tSahQFu84Qn93SGJwulfV1JJZc6WDBtkXswzwbELwokYIHc7";
	private static String access_token = "854816607939506176-cIUs5zGTk9i4SG3QysvDfnHrLpBJBl5";
	private static String access_token_secret = "Ws2SqhDshavsbqLWe5AEuYnHLaW0LdpztfYg5gRs4o3Wq";

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

		Twitter goodSpamTest = configureBot();

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

		for(int i = 0; i < 10; i++)
		{
			String zipCode = list.get(new Random().nextInt(list.size()));

			//create string to tweet
			String content = zipCode +" #LouCrimeZip";

			try {
				Tweet("loumetrobot", content, goodSpamTest);
				Thread.sleep(5000*60);
			} catch (TwitterException | InterruptedException e) {
				e.printStackTrace();
				System.out.println("Something went wrong.");
			}
		}


	}


	public static void Tweet (String userName, String msg, Twitter goodSpamTest) throws TwitterException, InterruptedException 
	{
		String tweet = "@" + userName + " " + msg;

		try
		{
			if (tweet.length() <= 140)
			{		
				//Send the Tweet
				Status status = goodSpamTest.updateStatus(tweet);

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
				Tweet(userName, newTweet, goodSpamTest);
				Tweet(userName, newTweet2, goodSpamTest);
			}
		}
		catch (TwitterException tex)
		{
			//WritingToFile.LogError(tex.getExceptionCode(), tex.getErrorMessage());
			 System.out.println(tex.getStatusCode() + " Good Spam");
		}

		catch (Exception ex)
		{
			//WritingToFile.LogError(ex.toString(), WritingToFile.exceptionStacktraceToString(ex));
			//WritingToFile.CSVFile("InfoLog.csv", tweet, userName, "", "", "NOT SENT");
			System.out.println("Exception.");
		}
	}

}


