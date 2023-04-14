import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.io.PrintStream;

public class FileIO {

	/*
	Returns the string of the filename entered by the user
	*/
	public static String getFileName()
	{
		Scanner user_input = new Scanner(System.in);
		
		System.out.printf("Please enter test file name[tsp_example_1.txt]: ");
//		String fileName = user_input.nextLine();
		String fileName = "tsp_example_4.txt";
		
		user_input.close();
		
		if(fileName.equals(""))
		{
			fileName = "tsp_example_4.txt";
		}
		return fileName;
	}
	
	/*
	Asks user for input file for tsp
	Searches for file on local directory
	Defaults to tsp_example_1.txt 
	Returns an array of cities for tsp and the filename entered by the user
	*/	
	public static City[] openMap(String fileName){

		
		City[] cities = new City[8];
		String path="./inputs/";
//		try
//		{
//			Scanner file = new Scanner(new File(path+fileName));
//			int i = 0;
			//make a city object out of each line in the file
//			while(file.hasNextLine())
//			{
//				//double size of cities if there isn't enough space in the array
//				if(i >= cities.length)
//				{
//					City[] newCities = new City[cities.length * 2];
//					for(int j = 0; j < cities.length; j++)
//					{
//						newCities[j] = cities[j];
//					}
//					cities = newCities;
//				}
//
//				cities[i] = new City(file.nextLine());
//				i++;
//
//			}
//			file.close();
			
//			// remove null values from array...
//			City[] newCities = new City[i];
//			for(int j = 0; j < i; j++)
//			{
//				newCities[j] = cities[j];
//			}
//			cities = newCities;
			//System.out.println("getX"+newCities[0].getX());
//		}
//		catch(IOException e)
//		{
//			System.out.println( e );
//			System.exit(1);
//		}

		//todo
		CSVReader reader = null;
		try {
			//parsing a CSV file into CSVReader class constructor
			reader = new CSVReader(new FileReader("./inputs/test01.csv"));
			String[] next = reader.readNext();

			int i = 0;
			//reads one line at a time
			while ((next = reader.readNext()) != null) {

				if(null == next){
					break;
				}
				if(i >= cities.length)
				{
					City[] newCities = new City[cities.length * 2];
					for(int j = 0; j < cities.length; j++)
					{
						newCities[j] = cities[j];
					}
					cities = newCities;
				}

				cities[i] = new City(next[0],i,Double.parseDouble(next[4]),Double.parseDouble(next[5]));
				i++;
				//Crime ID:String
//				System.out.print("ID-》"+next[0]+"  ");
//				System.out.println("\n");
				//id
//				System.out.println("ID"+i+"  ");
//
//				//Longitude:Double
//				System.out.print("Longitude"+Double.parseDouble(next[4])+"  ");
//				//Latitude:Double
//				System.out.print("Latitude"+Double.parseDouble(next[5]));
//				System.out.print("\n");
			}
			// remove null values from array...
			City[] newCities = new City[i];
			for(int j = 0; j < i; j++)
			{
				newCities[j] = cities[j];
			}
			cities = newCities;
			System.out.println(cities[1].getCrime()+" "+cities[1].getId()+" "+cities[1].getX()+" "+cities[1].getY());

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//todo
		

		return cities;
	}
	
	/*
	Saves results of TSP to passed fileName
	*/	
	public static void writeMap(double totalDistance, Stack<City> path, String fileName){
		try
		{	PrintStream writer = new PrintStream( new File(fileName));
			writer.printf("%.2f\n", totalDistance);
			while(!path.isEmpty())
			{
					//writer.printf("%d\n", path.pop().getId());
					writer.printf(path.pop().getCrime());
					writer.printf("\n");

			}

			writer.close();
		}
		catch(IOException e)
		{	
			System.out.println( e );
		}
	}
	

}

