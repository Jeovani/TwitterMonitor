package br.com.twitter.login;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class ConnectTwitter {
	
	public static Twitter oAuthManualTwitter () {
		
		String consumerKey = "9yEwBctD0ue4iryx5VsPmCLnl";
		String consumerSecret = "SFv522grkHXY98ig2XFIVo2Qoh5yJH2BG1VsJzGy5ge6Ocfc5l";
		String acessToken = "3050918313-J3tJKcZM78c4Wgq59CIMnp4MAjq8dJd3NI21Teq";
		String tokenSecret = "ZJGj3djSE7FfbkCT5wHlycExXDdAhWXZB9RAJPYNe4X8G";
		
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
