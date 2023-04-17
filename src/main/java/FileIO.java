import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.io.PrintStream;

public class FileIO {

	/*
	Created by Anson Sun
	*/
	public static String getFileName()
	{
		Scanner user_input = new Scanner(System.in);
		String fileName = "result.txt";
		
		user_input.close();
		
		if(fileName.equals(""))
		{
			fileName = "result.txt";
		}
		return fileName;
	}
	
	/*
	让用户给文件
	从本地找文件
	找不到就用 tsp_example_1.txt 
	返回保存城市数据的数组和文件名
	*/	
	public static City[] openMap(String fileName){
		City[] cities = new City[8];
		String path="./inputs/";
		CSVReader reader = null;
		try {
			//读CSV文件
			reader = new CSVReader(new FileReader("./inputs/test02.csv"));
			String[] next = reader.readNext();
			int i = 0;
			//每次读一行
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
			}
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
	把计算结果存进文件
	*/
	public static void writeMap(double totalDistance, Stack<City> path, String fileName){
		try
		{	PrintStream writer = new PrintStream( new File(fileName));
			writer.printf("Total distance is %.2f\n", totalDistance);
			while(!path.isEmpty())
			{
					writer.printf("%d", path.pop().getId());
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

