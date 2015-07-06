package br.com.twitter.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TransformationTwitter {
	
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

}
