package shapeGroupPeriodics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

	private ArrayList<File> inputFiles; //Stores filenames in input directory
	
	private String lastReportFilePath; //Path of last report
	private String newReportFilePath; //Path for new report
	private String filesDirectoryPath; //Path to input files directory
	private String wantedFileExtension; //File extension to look for
	
	public static Integer[] selectedShapeGroups; //Shape groups to look for
	
	
	
	private String resultMessage;
	
	public Parser(String lastReportFilePath, String newReportFilePath, String filesDirectoryPath, String wantedFileExtension) {
		this.lastReportFilePath = lastReportFilePath;
		this.newReportFilePath = newReportFilePath;
		this.filesDirectoryPath = filesDirectoryPath;
		this.wantedFileExtension = wantedFileExtension;
		
		resultMessage = new String();
	}
	
	
	public String CreateReport() {
		if(getInputFiles())
			resultMessage += "Input files successfully found.\n";

		//TODO: Read Files
		//TODO: Check against last report
		//TODO: Write new report
		//TODO: Finish method
		return resultMessage;
		
	}
	
	/**
	 * Gets the input files and filters out unwanted files
	 * @return True if successful
	 */
	private boolean getInputFiles() {
		File inputDirectory = new File(filesDirectoryPath);
		// Checks if input path is a directory
		if(!inputDirectory.isDirectory()) {
			resultMessage += "Error: Files directory path is not a directory.\n";
			return false;
		}
		
		File[] rawInputFiles = inputDirectory.listFiles(); // List of unfiltered files
		inputFiles = new ArrayList<File>();
		for(int i = 0; i < rawInputFiles.length; i++) {
			if(getFileExtension(rawInputFiles[i].getName()) == wantedFileExtension) {
				inputFiles.add(rawInputFiles[i]);
			}
		}
		// Checks if any files are found
		if(inputFiles.isEmpty()) {
			resultMessage += "Error: No input files found\n";
			return false;
		}
			
		return true;
	}
	
	/**
	 * Gets the extension from the filename
	 * @param fileName The name of the file
	 * @return The extension of the filename
	 */
	private String getFileExtension(String fileName){
		int i = fileName.lastIndexOf(".");
		if(i > 0) {
			return fileName.substring(i+1);
		}else {
			return "";
		}
	}
	
	private boolean readFiles() {
		for(int i = 0; i < inputFiles.size(); i++) {
			try(Scanner scanner = new Scanner(inputFiles.get(i))) {
				
				while(line != null) {
					
				}
				
				
			}catch(Exception ex) {
				resultMessage += ex.toString();
				return false;
			}
		}
		//TODO: Finish method
		return true;
	}
}
