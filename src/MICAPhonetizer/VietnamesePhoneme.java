package MICAPhonetizer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

/**
 * @author Nguyễn Tiến Thành
 * SpeechCom department, International Research Institute MICA
 * 
 */

public class VietnamesePhoneme {
	
	private ArrayList<String> initConL = new ArrayList<String>();
	private ArrayList<String> initConP = new ArrayList<String>();
	private ArrayList<String> initConI = new ArrayList<String>();
	private ArrayList<String> finalConL = new ArrayList<String>();
	private ArrayList<String> finalConP = new ArrayList<String>();
	private ArrayList<String> finalConI = new ArrayList<String>();
	private ArrayList<String> vowelL = new ArrayList<String>();
	private ArrayList<String> vowelP = new ArrayList<String>();
	private ArrayList<String> vowelI = new ArrayList<String>();
	private ArrayList<String> midL = new ArrayList<String>();
	private ArrayList<String> midP = new ArrayList<String>();
	private ArrayList<String> midI = new ArrayList<String>();

	/*
	String initConL[] = {"b", "đ", "x", "s", "gh", "g", "kh", "l", "v", "th", "d", "gi", "r", "ph", "tr",
			"ch", "h", "c", "k", "q", "t", "p", "n", "m", "nh", "ngh", "ng"};  // 27 phụ âm đầu
	String initConP[] = {"b", "d", "s", "s", "G", "G", "X", "l", "v", "th", "z", "z", "z", "ph", "c",
			"c", "h", "k", "k", "k", "t", "b", "n", "m", "J", "N", "N"};

	String finalConL[] = {"t", "p", "n", "ch", "c", "c", "m", "nh", "ng", "ng", "o", "u", "i", "y"};  // 14 phụ âm cuối
//	String finalConP[] = {"t", "p", "n", "kz", "kp", "k", "m", "Nz", "Nm", "N", "wz", "wz", "j", "j"};

	String vowelL[] = {"ia", "iê", "yê", "ya", "ua", "uô", "ưa", "ươ",
			"ư", "ơ", "ô", "ê", "e", "ă", "â", "a", "a", "a", "oo", "o", "o", "i", "y", "u"};
//			"a", "a", "a", "ă", "â", "e", "ê", "i", "y", "oo", "o", "o", "ô", "ơ", "u", "ư"};   // 16 nguyên âm
	String vowelP[] = {"ie", "ie", "ie", "ie", "uo", "uo", "M7", "M7",
			"M", "7", "o", "e", "E", "aX", "7X", "a", "aX", "EX", "O", "O", "OX", "i", "i", "u"};
//			"a", "aX", "EX", "aX", "WX", "E", "e", "i", "i", "OF", "O", "OX", "o", "W", "u", "M"};

	String divowelL[] = {"ia", "iê", "yê", "ya", "ua", "uô", "ưa", "ươ"};	// 8 nguyên âm kép
	String divowelP[] = {"i@", "i@", "i@", "i@", "u@", "u@", "M@", "M@"};
	
*/	
	private String vowelTone[] = {"à", "ã", "ả", "á", "ạ", "ằ", "ẵ", "ẳ", "ắ", "ặ", "ầ", "ẫ", "ẩ", "ấ", "ậ",
			"è", "ẽ", "ẻ", "é", "ẹ", "ề", "ễ", "ể", "ế", "ệ", "ì", "ĩ", "ỉ", "í", "ị",
			"ỳ", "ỹ", "ỷ", "ý", "ỵ", "ò", "õ", "ỏ", "ó", "ọ", "ồ", "ỗ", "ổ", "ố", "ộ",
			"ờ", "ỡ", "ở", "ớ", "ợ", "ù", "ũ", "ủ", "ú", "ụ", "ừ", "ữ", "ử", "ứ", "ự"}; // 60 nguyên âm có dấu

	private String vowelWithoutTone[] = {"a", "a", "a", "a", "a", "ă", "ă", "ă", "ă", "ă", "â", "â", "â", "â", "â",
					"e", "e", "e", "e", "e", "ê", "ê", "ê", "ê", "ê", "i", "i", "i", "i", "i",
					"y", "y", "y", "y", "y", "o", "o", "o", "o", "o", "ô", "ô", "ô", "ô", "ô",
					"ơ", "ơ", "ơ", "ơ", "ơ", "u", "u", "u", "u", "u", "ư", "ư", "ư", "ư", "ư"};

	private String toneNum[] = {"2", "3", "4", "5", "6", "2", "3", "4", "5", "6", "2", "3", "4", "5", "6",
			"2", "3", "4", "5", "6", "2", "3", "4", "5", "6", "2", "3", "4", "5", "6",
			"2", "3", "4", "5", "6", "2", "3", "4", "5", "6", "2", "3", "4", "5", "6",
			"2", "3", "4", "5", "6", "2", "3", "4", "5", "6", "2", "3", "4", "5", "6"};

	
	
	void readPhonemeDatabase(String filename) {
		
		String phoneData = readTextFile(filename);
		String[] terms = phoneData.split("[\n]+");
		
		for (String s1 : terms) {
			System.out.println(s1 + "\n---");
			
			String[] elements = s1.split("[\\s]+");
			
			if (elements.length >= 3) {
				System.out.println(elements[0] + " | " + elements[1] + " | " + elements[2]);
				initConL.add(elements[0]);
				initConP.add(elements[2]);
				initConI.add(elements[1]);
			} else
				continue;
		}
		
		
		
		
	}
	
	void readPhonemeDatabaseExcell(String filename) {
		
		InputStream inp;
		try {
			inp = new FileInputStream(filename);
			Workbook wb;
			try {
				wb = WorkbookFactory.create(inp);
				//bắt đầu với sheet Phụ âm đầu
				Sheet sheet = wb.getSheetAt(0);
				int count = 1;
			    Row row = sheet.getRow(count);
//			    Cell cell = row.getCell(0);
			    while (row != null) {
			    	initConL.add(row.getCell(0).toString().trim());
					initConP.add(row.getCell(2).toString().trim());
					initConI.add(row.getCell(1).toString().trim());
					
					count++;
					row = sheet.getRow(count);
			    } 
			   // System.out.println("Vậy là có tất cả : " + initConL.size() + " phụ âm đầu");
			  //tiếp theo là sheet Phụ âm đầu
				sheet = wb.getSheetAt(1);
				count = 1;
			    row = sheet.getRow(count);
			    while (row != null) {
			    	finalConL.add(row.getCell(0).toString().trim());
			    	finalConP.add(row.getCell(2).toString().trim());
			    	finalConI.add(row.getCell(1).toString().trim());
					
					count++;
					row = sheet.getRow(count);
			    } 
			    //System.out.println("Vậy là có tất cả : " + finalConL.size() + " âm cuối");
			  //tiếp nữa là sheet Nguyên âm
				sheet = wb.getSheetAt(2);
				count = 1;
			    row = sheet.getRow(count);
			    while (row != null) {
			    	vowelL.add(row.getCell(0).toString().trim());
			    	vowelP.add(row.getCell(2).toString().trim());
			    	vowelI.add(row.getCell(1).toString().trim());
					
					count++;
					row = sheet.getRow(count);
			    } 
			   // System.out.println("Vậy là có tất cả : " + vowelL.size() + " nguyên âm");
			  //cuối cùng là sheet Âm đệm
				sheet = wb.getSheetAt(3);
				count = 1;
			    row = sheet.getRow(count);
			    while (row != null) {
			    	midL.add(row.getCell(0).toString().trim());
			    	midP.add(row.getCell(2).toString().trim());
			    	midI.add(row.getCell(1).toString().trim());
					
					count++;
					row = sheet.getRow(count);
			    } 
			    //System.out.println("Vậy là có tất cả : " + midL.size() + " âm đệm");
			    
			    
			} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private String readTextFile(String filename) {
		String output = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        output += line + "\n";
		    }
		    reader.close();
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return output;
	}
	
	ArrayList<String> convertSentenceToPhonemes(String sentence) {
		ArrayList<String> output = new ArrayList<String>();
		
		String[] syllables = sentence.split("[\\s@&.?$+-]+");
		String xSAMPA = "";
		String iPA = "";
		
		for (String syl : syllables) {
			
			ArrayList<String> phones = convertSyllableToPhonemes(syl);
			
			for (int i = 1 ; i<phones.size() ; i+=2 ) {
				xSAMPA += phones.get(i);				
			}

			for (int i = 2 ; i<phones.size() ; i+=2 ) {
				iPA += phones.get(i);				
			}
			
			xSAMPA += " ";
			iPA += " ";
		}
		output.add(xSAMPA.trim());
		output.add(iPA.trim());
		
		return output;
	}
	
	ArrayList<String> convertSentenceToPhonemesWithTone(String sentence) {
		ArrayList<String> output = new ArrayList<String>();
		
		String[] syllables = sentence.split("[\\s@&.?$+-]+");
		String xSAMPA = "";
		String iPA = "";
		
		for (String syl : syllables) {
			
			ArrayList<String> phones = convertSyllableToPhonemesWithTone(syl);
			
			for (int i = 1 ; i<phones.size() ; i+=2 ) {
				xSAMPA += phones.get(i);				
			}

			for (int i = 2 ; i<phones.size() ; i+=2 ) {
				iPA += phones.get(i);				
			}
			
			xSAMPA += " ";
			iPA += " ";
		}
		output.add(xSAMPA.trim());
		output.add(iPA.trim());
		
		return output;
	}
	
///*	
	ArrayList<String> convertSyllableToPhonemes(String syllable) {

		ArrayList<String> output = new ArrayList<String>();

		String initStr, midStr, finalStr, tone;
		String iniPh, midPh, nucPh, finPh;
		String iniIPA, midIPA, nucIPA, finIPA;
		String syllableWTone = syllable;

		//############ bước 1 - xác định và bỏ dấu của âm tiết

		tone = "1";


		for (int i = 0 ; i < 60 ; i++) {

			int posOfVowel = syllable.indexOf(vowelTone[i]);

			if (posOfVowel >= 0) {

				int lengOfVowel = vowelTone[i].length();

				tone = toneNum[i];
				syllableWTone = syllable.replace(vowelTone[i], vowelWithoutTone[i]);
				int sylLen = syllableWTone.length();		
				if (tone.equals("5") && sylLen>1) {
							
					int posTemp = syllableWTone.lastIndexOf("ch");
					if ((syllableWTone.substring(sylLen - 1).equals("c"))
							|| (syllableWTone.substring(sylLen - 1).equals("t"))
							|| (syllableWTone.substring(sylLen - 1).equals("p"))
							|| ((sylLen - 2) == posTemp))

						tone = "7";

						break;
				} else if (tone.equals("6") && sylLen>1) {
					
					int posTemp = syllableWTone.lastIndexOf("ch");
					if ((syllableWTone.substring(sylLen - 1).equals("c"))
							|| (syllableWTone.substring(sylLen - 1).equals("t"))
							|| (syllableWTone.substring(sylLen - 1).equals("p"))
							|| ((sylLen - 2) == posTemp))

						tone = "8";
				}

				break;
			}
		}

		//########### bước 2 - tách âm tiết thành 3 phần để xác định âm vị

		//- duyệt tìm các nguyên âm kép và nguyên âm

		iniPh = midPh = nucPh = finPh = iniIPA = midIPA = nucIPA = finIPA = "NUL";

		for (int i = 0 ; i < vowelL.size() ; i++) {
			int posOfVow = syllableWTone.indexOf(vowelL.get(i));

			if (posOfVow >= 0) {
				int lenOfVow = vowelL.get(i).length();

				nucPh = vowelP.get(i);
				nucIPA = vowelI.get(i);
				midStr = vowelL.get(i);
				initStr = syllableWTone.substring(0, posOfVow);
				finalStr = syllableWTone.substring(posOfVow + lenOfVow);

				// xử lý đoạn string cuối trước

				if (!finalStr.equals("")) {

					// xử lý lại âm vị với a và o
					if (midStr.equals("a")) {
						if ((finalStr.equals("u")) || (finalStr.equals("y"))) {
							nucPh = vowelP.get(i+1);
							nucIPA = vowelI.get(i+1);
						} else if ((finalStr.equals("nh")) || (finalStr.equals("ch"))) {
							nucPh = vowelP.get(i+2);
							nucIPA = vowelI.get(i+2);
						}
					} else if (midStr.equals("o")) {
						if ((finalStr.equals("ng")) || (finalStr.equals("c"))) {
							nucPh = vowelP.get(i+1);
							nucIPA = vowelI.get(i+1);
						}
					}


					for (int i1 = 0; i1 < finalConL.size() ; i1++) {

						if (finalStr.equals(finalConL.get(i1))) {

							if (finalStr.equals("c")) {
								if ((midStr.equals("u")) || (midStr.equals("o")) || (midStr.equals("ô"))) {
									finPh = finalConP.get(i1+1);
									finIPA = finalConI.get(i1+1);
								} else {
									finPh = finalConP.get(i1);
									finIPA = finalConI.get(i1);
								}
							} else if (finalStr.equals("ng")) {
								if ((midStr.equals("u")) || (midStr.equals("o")) || (midStr.equals("ô"))) {
									finPh = finalConP.get(i1+1);
									finIPA = finalConI.get(i1+1);
								} else {
									finPh = finalConP.get(i1);
									finIPA = finalConI.get(i1);
								}
							} else {
								finPh = finalConP.get(i1);
								finIPA = finalConI.get(i1);
							}

							break;
						}
					}
				}

				// xử lý đoạn string đầu sau

				if (!initStr.equals("")) {

					// xử lý âm đệm u và o
					int posOfMid = -1;
					for (int im = 0 ; im < midL.size() ; im++) { 
						posOfMid = initStr.indexOf(midL.get(im)); 
						if (posOfMid >= 0) {
							initStr = initStr.substring(0, posOfMid); 
							midPh = midP.get(0);
							midIPA = midI.get(0);
							break;
						} 
					}
					
					

					// bắt đầu tìm phụ âm đầu
					for (int i2 = 0; i2 < initConL.size() ; i2++) {

						if (initStr.equals(initConL.get(i2))) {

							iniPh = initConP.get(i2);
							iniIPA = initConI.get(i2);
							int it;

							if ((initStr.equals("q")) && (midStr.equals("ua"))) {
								iniPh = "k"; iniIPA = "k";
								midPh = midP.get(0); midIPA = midI.get(0);
								nucPh = "a"; nucIPA = "a";
							} else if ((initStr.equals("g")) && (midStr.equals("ia"))) {
								iniPh = "z"; iniIPA = "z";
								nucPh = "a"; nucIPA = "a";
							} else if ((initStr.equals("g")) && (midStr.equals("i"))) {
								//it = initConP
								iniPh = "z"; iniIPA = "z";
							}

							break;
						}
					}
				}


				break;
			}
		}

		output.clear();

		output.add(tone);
		
		if (iniPh != "NUL") {
			output.add(iniPh);
			output.add(iniIPA);
		}
		if (midPh != "NUL") {
			output.add(midPh);
			output.add(midIPA);
		}
//		else
//			output.add(midPh + tone);

		if (nucPh != "NUL") {
			output.add(nucPh);
			output.add(nucIPA);
		}
		if (finPh != "NUL") {
			output.add(finPh);
			output.add(finIPA);
		}
//		else
//			output.add(finPh + tone);

		return output;
	}
	
	ArrayList<String> convertSyllableToPhonemesWithTone(String syllable) {

		ArrayList<String> output = new ArrayList<String>();

		String initStr, midStr, finalStr, tone;
		String iniPh, midPh, nucPh, finPh;
		String iniIPA, midIPA, nucIPA, finIPA;
		String syllableWTone = syllable;

		//############ bước 1 - xác định và bỏ dấu của âm tiết

		tone = "1";
		for (int i = 0 ; i < 60 ; i++) {

			int posOfVowel = syllable.indexOf(vowelTone[i]);

			if (posOfVowel >= 0) {

				tone = toneNum[i];
				syllableWTone = syllable.replace(vowelTone[i], vowelWithoutTone[i]);
				int sylLen = syllableWTone.length();		
				if (tone.equals("5") && sylLen>1) {
							
					int posTemp = syllableWTone.lastIndexOf("ch");
					if ((syllableWTone.substring(sylLen - 1).equals("c"))
							|| (syllableWTone.substring(sylLen - 1).equals("t"))
							|| (syllableWTone.substring(sylLen - 1).equals("p"))
							|| ((sylLen - 2) == posTemp))

						tone = "7";

						break;
				} else if (tone.equals("6") && sylLen>1) {
					
					int posTemp = syllableWTone.lastIndexOf("ch");
					if ((syllableWTone.substring(sylLen - 1).equals("c"))
							|| (syllableWTone.substring(sylLen - 1).equals("t"))
							|| (syllableWTone.substring(sylLen - 1).equals("p"))
							|| ((sylLen - 2) == posTemp))

						tone = "8";
				}
				break;
			}
		}
		//########### bước 2 - tách âm tiết thành 3 phần để xác định âm vị

		//- duyệt tìm các nguyên âm kép và nguyên âm

		iniPh = midPh = nucPh = finPh = iniIPA = midIPA = nucIPA = finIPA = "NUL";

		for (int i = 0 ; i < vowelL.size() ; i++) {
			int posOfVow = syllableWTone.indexOf(vowelL.get(i));

			if (posOfVow >= 0) {
				int lenOfVow = vowelL.get(i).length();

				nucPh = vowelP.get(i);
				nucIPA = vowelI.get(i);
				midStr = vowelL.get(i);
				initStr = syllableWTone.substring(0, posOfVow);
				finalStr = syllableWTone.substring(posOfVow + lenOfVow);

				// xử lý đoạn string cuối trước

				if (!finalStr.equals("")) {

					// xử lý lại âm vị với a và o
					if (midStr.equals("a")) {
						if ((finalStr.equals("u")) || (finalStr.equals("y"))) {
							nucPh = vowelP.get(i+1);
							nucIPA = vowelI.get(i+1);
						} else if ((finalStr.equals("nh")) || (finalStr.equals("ch"))) {
							nucPh = vowelP.get(i+2);
							nucIPA = vowelI.get(i+2);
						}
					} else if (midStr.equals("o")) {
						if ((finalStr.equals("ng")) || (finalStr.equals("c"))) {
							nucPh = vowelP.get(i+1);
							nucIPA = vowelI.get(i+1);
						}
					}


					for (int i1 = 0; i1 < finalConL.size() ; i1++) {

						if (finalStr.equals(finalConL.get(i1))) {

							if (finalStr.equals("c")) {
								if ((midStr.equals("u")) || (midStr.equals("o")) || (midStr.equals("ô"))) {
									finPh = finalConP.get(i1+1);
									finIPA = finalConI.get(i1+1);
								} else {
									finPh = finalConP.get(i1);
									finIPA = finalConI.get(i1);
								}
							} else if (finalStr.equals("ng")) {
								if ((midStr.equals("u")) || (midStr.equals("o")) || (midStr.equals("ô"))) {
									finPh = finalConP.get(i1+1);
									finIPA = finalConI.get(i1+1);
								} else {
									finPh = finalConP.get(i1);
									finIPA = finalConI.get(i1);
								}
							} else {
								finPh = finalConP.get(i1);
								finIPA = finalConI.get(i1);
							}

							break;
						}
					}
				}

				// xử lý đoạn string đầu sau

				if (!initStr.equals("")) {

					// xử lý âm đệm u và o
					int posOfMid = -1;
					for (int im = 0 ; im < midL.size() ; im++) { 
						posOfMid = initStr.indexOf(midL.get(im)); 
						if (posOfMid >= 0) {
							initStr = initStr.substring(0, posOfMid); 
							midPh = midP.get(0);
							midIPA = midI.get(0);
							break;
						} 
					}				
					
					// bắt đầu tìm phụ âm đầu
					for (int i2 = 0; i2 < initConL.size() ; i2++) {

						if (initStr.equals(initConL.get(i2))) {

							iniPh = initConP.get(i2);
							iniIPA = initConI.get(i2);
							int it;

							if ((initStr.equals("q")) && (midStr.equals("ua"))) {
								iniPh = "k"; iniIPA = "k";
								midPh = midP.get(0); midIPA = midI.get(0);
								nucPh = "a"; nucIPA = "a";
							} else if ((initStr.equals("g")) && (midStr.equals("ia"))) {
								iniPh = "z"; iniIPA = "z";
								nucPh = "a"; nucIPA = "a";
							} else if ((initStr.equals("g")) && (midStr.equals("i"))) {
								//it = initConP
								iniPh = "z"; iniIPA = "z";
							}
							break;
						}
					}
				}
				break;
			}
		}

		output.clear();

		output.add(tone);
		
		if (iniPh != "NUL") {
			output.add(iniPh);
			output.add(iniIPA);
		}
		if (midPh != "NUL") {
			output.add(midPh);
			output.add(midIPA);
		}

		if (nucPh != "NUL") {
			output.add(nucPh + tone);
			output.add(nucIPA + tone);
		}
		if (finPh != "NUL") {
			output.add(finPh);
			output.add(finIPA);
		}

		return output;
	}
}
