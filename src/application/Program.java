package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
		
		String path = "C:\\temp\\out.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			
//			A Classe FileWriter verificará o caminho e o nome do arquivo informado, caso exista o mesmo será substituido,
//			caso não exista o mesmo será criado.
			
//			Para contornar isso e manter o conteúdo do arquivo intacto, basta passar um segundo parâmetro com o valor true.
//			Desta forma o novo conteudo será inserido no final do arquivo.
			
			for(String str : lines) {
				bw.write(str);
				bw.newLine(); // Quebra a linha
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
