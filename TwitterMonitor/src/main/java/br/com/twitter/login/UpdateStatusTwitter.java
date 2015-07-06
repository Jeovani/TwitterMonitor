package br.com.twitter.login;

import twitter4j.Twitter;
import twitter4j.TwitterException;

public class UpdateStatusTwitter{
	
	private static void updateStatusTwitter () {
		Twitter twitter = ConnectTwitter.oAuthTwitter();
		
		try {
			twitter.updateStatus("Teste de Status");
		} catch (TwitterException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		updateStatusTwitter();
	}

}
