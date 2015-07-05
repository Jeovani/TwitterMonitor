package br.com.twitter.login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class LogInTwitter {
	
	private static String consumerKey = "9yEwBctD0ue4iryx5VsPmCLnl";
	private static String consumerSecret = "SFv522grkHXY98ig2XFIVo2Qoh5yJH2BG1VsJzGy5ge6Ocfc5l";
	private static String acessToken = "3050918313-J3tJKcZM78c4Wgq59CIMnp4MAjq8dJd3NI21Teq";
	private static String tokenSecret = "ZJGj3djSE7FfbkCT5wHlycExXDdAhWXZB9RAJPYNe4X8G";
	
	private static Twitter configuredTwitter () {
		
		ConfigurationBuilder configBuilder = new ConfigurationBuilder().setDebugEnabled(true);
//		configBuilder.setOAuthConsumerKey(consumerKey);
//		configBuilder.setOAuthConsumerSecret(consumerSecret);
//		configBuilder.setOAuthAccessToken(acessToken);
//		configBuilder.setOAuthAccessTokenSecret(tokenSecret);	
		
//		TwitterFactory tf = new TwitterFactory().getInstance();
		Twitter twitter = new TwitterFactory().getInstance();	
		
		return twitter;
		
	}
	
	private static void updateStatusTwitter () {
		Twitter twitter = configuredTwitter();
		
		try {
//			System.out.println(twitter.getOAuthRequestToken());
//			System.out.println(twitter.getOAuthRequestToken().getAuthorizationURL());
			twitter.updateStatus("Teste de Status");
		} catch (TwitterException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void convertToDate () throws Exception{
		
		String fileEdgde = "D:/Download/Browser/15Mar.vFINAL [Edges].csv";
		
		String fileEdgdeOutput = "D:/Download/Browser/15Mar.vFINAL [Edges]-output.csv";
		
		FileWriter fileWriter = new FileWriter(fileEdgdeOutput);
		BufferedWriter writer = new BufferedWriter( fileWriter );
		writer.append("Fonte|Alvo|Tipo|ID|Rótulo|Peso|Data|Hora").append("\n");
		
		Scanner scanner = new Scanner(new File(fileEdgde));
		scanner.nextLine();
		String line = "";
		
		while(scanner.hasNext()){
			line = scanner.nextLine();
			String[] values = line.split(",");
			Date date = new Date(Long.parseLong(values[6]));
			SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm:ss");
			String save = values[0] + "|" + values[1] + "|" + values[2] + "|" + 
					values[3] + "|" + values[4] + "|" + values[5] + "|" + formatDate.format(date) + "|" + formatHour.format(date);
			if(!values[0].equals(values[1])){
				writer.append(save);
				writer.append("\n");
			}
		}
		
		writer.close();
		fileWriter.close();
		
	}
	
	private static void countFonte () throws Exception{
		Map<String, Integer> countFonte = new HashMap<String, Integer>();
		Map<String, Integer> countAlvo = new HashMap<String, Integer>();
		String fileEdgde = "C:/Users/Jeovani/Desktop/Gephis/BaseMasterChefe/15Mar.vFINAL [Edges] - Amostra.csv";
		
		String fileEdgdeOutput = "C:/Users/Jeovani/Desktop/Gephis/BaseMasterChefe/Transformada/15Mar.vFINAL [Edges] - Count-Java02.csv";
		
		FileWriter fileWriter = new FileWriter(fileEdgdeOutput);
		BufferedWriter writer = new BufferedWriter( fileWriter );
		writer.append("Fonte|QtdFonte|QtdAlvo").append("\n");
		
		Scanner scanner = new Scanner(new File(fileEdgde));
		scanner.nextLine();
		String line = "";
		
		while(scanner.hasNext()){
			line = scanner.nextLine();
			String[] values = line.split("\\|");
			String fonte = values[0];
			if(countFonte.get(fonte) == null){
				countFonte.put(fonte, 1);
			}else{
				Integer num = countFonte.get(fonte);
				countFonte.put(fonte, num + 1);
			}
		}
		
		Scanner scanner2 = new Scanner(new File(fileEdgde));
		scanner2.nextLine();
		String line2 = "";
		
		while(scanner2.hasNext()){
			line2 = scanner2.nextLine();
			String[] values = line2.split("\\|");
			String fonte = values[1];
			if(countAlvo.get(fonte) == null){
				countAlvo.put(fonte, 1);
			}else{
				Integer num = countAlvo.get(fonte);
				countAlvo.put(fonte, num + 1);
			}
		}
		
		Iterator<Entry<String, Integer>> iterator = countFonte.entrySet().iterator();
		while (iterator.hasNext()){
			Entry<String, Integer> next = iterator.next();
			Integer alvo = countAlvo.get(next.getKey());
			writer.append(next.getKey() + "|" + next.getValue() + "|" + (alvo == null ? "0" : alvo));
			writer.append("\n");
		}
		
		writer.close();
		fileWriter.close();
		
	}
	
	private static void convertToDate2 () throws Exception{
		
		String fileNode = "C:/Users/Jeovani/Desktop/Gephis/BaseMasterChefe/15Mar.vFINAL [Nodes].csv";
		
		String fileNodeOutput = "C:/Users/Jeovani/Desktop/Gephis/BaseMasterChefe/Transformada/15Mar.vFINAL [Nodes].csv";
		
		FileWriter fileWriter = new FileWriter(fileNodeOutput);
		BufferedWriter writer = new BufferedWriter( fileWriter );
		
		Scanner scannerNode = new Scanner(new File(fileNode));
		scannerNode.nextLine();
		String line = "";
		
		while(scannerNode.hasNext()){
			line = scannerNode.nextLine();
			String[] values = line.split(",");
			System.out.println(values[2]);
			String dataXX = values[2].replace("\"", "").replace(";;", "").replace(",,", "").replace(",", "").replace(";", "");
			Date date = new Date(Long.parseLong(dataXX));
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			
			String save = values[0] + "|" + values[1] + "|" + format.format(date);
			
			System.out.println(save);
			writer.append(save);
			writer.append("\n");
		}
		
		writer.close();
		fileWriter.close();

	}
	
	   private static void writeFinalRules (StringBuilder builder){
           FileWriter file;
           try {
        	   file = new FileWriter("output/FinalRules.txt");
               BufferedWriter writer = new BufferedWriter( file );
                 
               writer.write(builder.toString());
                 
               writer.close();
               file.close();
           } catch (IOException e) {
                  System.out.println(e);
           }
    }
	
	
	public static void main(String[] args) throws Exception{
//		countFonte();
		convertToDate();
//		updateStatusTwitter();
	}

}
