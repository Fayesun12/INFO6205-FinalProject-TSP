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

//		String fileName = user_input.nextLine();
		String fileName = "result.txt";
		
		user_input.close();
		
		if(fileName.equals(""))
		{
			fileName = "result.txt";
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
		CSVReader reader = null;
		try {
			//parsing a CSV file into CSVReader class constructor
			reader = new CSVReader(new FileReader("./inputs/test02.csv"));
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

		

		return cities;
	}
	
	/*
	Saves results of TSP to passed fileName
	*/
	public static void writeMap(double totalDistance, Stack<City> path, String fileName){
		try
		{	PrintStream writer = new PrintStream( new File(fileName));
			writer.printf("Total distance is %.2f\n", totalDistance);
			while(!path.isEmpty())
			{
					writer.printf("%d", path.pop().getId());
					//writer.printf(path.pop().getCrime());
					writer.printf("->");

			}

			writer.close();
		}
		catch(IOException e)
		{	
			System.out.println( e );
		}
	}
	

}

