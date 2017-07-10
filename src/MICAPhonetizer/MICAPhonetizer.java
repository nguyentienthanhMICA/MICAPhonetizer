package MICAPhonetizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author Nguyễn Tiến Thành
 * SpeechCom department, International Research Institute MICA
 * 
 */
public class MICAPhonetizer {

	/**
	 * @param args
	 * @return 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Xin chào các bạn hahaha");
		VietnamesePhoneme mVP = new VietnamesePhoneme();
		
		String databaseFile = args[0];	
		mVP.readPhonemeDatabaseExcell(databaseFile);
		
		String input_file = args[1];
		String inputtext = readTextFile(input_file).toLowerCase();
		String output_file = args[2];
		
//		mVP.readPhonemeDatabaseExcell("D:\\CODE\\GitHub\\MICAPhonetizer\\resources\\phonemes.xlsx");

		ArrayList<String> result = mVP.convertSentenceToPhonemesWithTone(inputtext);
		
		String output = "";
		output += "IPA:\n" + result.get(1) + "\n\n---\nXSAMPA:\n" + result.get(0);
		writeFile(output, output_file);
		
//		return output;
		
//		System.out.println(mVP.getToneFromSyllable("thánh"));
//		System.out.println(mVP.getToneFromSyllable("thách"));
//		System.out.println(mVP.getToneFromSyllable("thạnh"));
		
/*				
		System.out.println("Mời nhập vào âm tiết: ");
		Scanner scanner = new Scanner(System.in);
		String test = scanner.nextLine().trim();
		while(!test.equals("z")) {
			ArrayList<String> result = mVP.convertSentenceToPhonemesWithTone(test);
			
			System.out.print("XSAMPA : ");
			System.out.println(result.get(0));
			
			System.out.print("IPA : ");
			System.out.println(result.get(1));
			
			System.out.println("---");
			test = scanner.nextLine();
		}
*/
		
//		String unicodeMessage =
//	            "\u4e16\u754c\u4f60\u597d\uff01 \n \u02C0";
//		
//		System.out.println(unicodeMessage);
	}
	
	static String readTextFile(String filename) {
		String output = "";
		try {
			File fileDir = new File(filename);

			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

			String str;

			while ((str = in.readLine()) != null) {
				output += str + "\n";
			}

			in.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return output;

//		String output = "";
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader(filename));
//		    String line = null;
//		    while ((line = reader.readLine()) != null) {
//		        output += line + "\n";
//		    }
//		    reader.close();
//		} catch (IOException x) {
//		    System.err.format("IOException: %s%n", x);
//		}
//		return output;
	}
	
	static void writeFile(String data, String filename) throws IOException {
		Writer out = new BufferedWriter(new OutputStreamWriter(
			    new FileOutputStream(filename), "UTF-8"));
			try {
			    out.write(data);
			} finally {
			    out.close();
			}

//		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
//
//			
//			bw.write(data);
//
//			// no need to close it.
//			//bw.close();
//
//			System.out.println("Done");
//
//		} catch (IOException e) {
//
//			e.printStackTrace();
//
//		}
	}
	
	String convertSylToPhonemes(String syllable) {
		
		String output = "";
		
		return output;
	}
}
