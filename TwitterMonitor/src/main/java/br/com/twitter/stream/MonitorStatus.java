package br.com.twitter.stream;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import br.com.twitter.connect.ConnectTwitter;

public class MonitorStatus {
	
	private static void monitorStatusTwitter () {
		
		TwitterStream twitterStream = ConnectTwitter.oAuthStreamTwitter();
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
            	String screenName = status.getUser().getScreenName();
            	if(screenName.startsWith("jeo")){
            		System.out.println("@" + screenName + " - " + status.getText());
            	}
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            @Override
            public void onStallWarning(StallWarning warning) {
                System.out.println("Got stall warning:" + warning);
            }

            @Override
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };
        twitterStream.addListener(listener);
        twitterStream.sample();
		
	}
	
	public static void main(String[] args) {
		
	}

}
