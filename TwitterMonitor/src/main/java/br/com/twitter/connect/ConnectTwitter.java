package br.com.twitter.connect;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class ConnectTwitter {
	
	public static Twitter oAuthManualTwitter () {
		
		String consumerKey = "";
		String consumerSecret = "";
		String acessToken = "";
		String tokenSecret = "";
		
		ConfigurationBuilder configBuilder = new ConfigurationBuilder().setDebugEnabled(true);
		configBuilder.setOAuthConsumerKey(consumerKey);
		configBuilder.setOAuthConsumerSecret(consumerSecret);
		configBuilder.setOAuthAccessToken(acessToken);
		configBuilder.setOAuthAccessTokenSecret(tokenSecret);	
		
		Twitter twitter = new TwitterFactory().getInstance();
		
		return twitter;
		
	}
	
	public static Twitter oAuthTwitter () {
		return new TwitterFactory().getInstance();
	}
	
	public static TwitterStream oAuthStreamTwitter () {
		return new TwitterStreamFactory().getInstance();
	}

}
