package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		File spreadSheet = new File("C:\\temp\\planilhas\\products.csv");
		File[] folders = new File("C:\\temp\\planilhas").listFiles(File::isDirectory);
		Boolean folderIsExists = Arrays.asList(folders).stream().anyMatch(x -> x.getName().equals("out"));	
		
		if(!folderIsExists) {
			Boolean created = new File("C:\\temp\\planilhas\\out").mkdir();
			if(created) System.out.println("Directory successfully created");
		}
			
		
		try (
			Scanner scan = new Scanner(spreadSheet); 
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\temp\\planilhas\\out\\summary.csv", true));
		){
			
			while(scan.hasNextLine()) {
				String[] parametros = scan.nextLine().split(",");
				
				String name = parametros[0];
				Double price = Double.valueOf(parametros[1]);
				Integer quantity = Integer.valueOf(parametros[2]);
				Product product = new Product(name, price, quantity);
				
				bw.write(product.getName() + "," + product.getAccountTotal());
				bw.newLine();
			}
			
			System.out.println("Spreadsheet created successfully");
			
			scan.close();
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
