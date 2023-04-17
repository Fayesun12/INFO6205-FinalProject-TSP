import java.util.Objects;

/**
 * Created by FanyeSun
 */
public class Edge implements Comparable<Edge> {

    private int source;
    private int destination;
    private double weight;

    public Edge(int source, int destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        if (this.weight < other.weight)
            return -1;
        else if (this.weight > other.weight)
            return 1;
        else return 0;
    }

    public double getWeight() {
        return weight;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Edge))
            return false;
        Edge e = (Edge)o;
        return (source == e.source) && (destination == e.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, weight);
    }

    @Override
    public String toString() {
        return source + " to " + destination + " w/ weight of " + weight;
    }
}
