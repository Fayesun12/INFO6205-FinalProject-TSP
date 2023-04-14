import java.util.Scanner;

	/*
	Create City in the tsp
	*/	

public class City {
	private int id;
	private String crime;
	private double x;
	private double y;
	/*
	Line from a tsp file and converts it into a city object
	*/	
	public City(String line)
	{
		Scanner s = new Scanner(line);
		this.id = s.nextInt();
		this.x = s.nextDouble();
		this.y = s.nextDouble();
	}
	public City(String crime,int id,double x,double y)
	{
		this.crime = crime;
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}

	public String  getCrime()
	{
		return this.crime;
	}
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof City))
            return false;
        City c = (City)o;
        return (id == c.id);
    }

}