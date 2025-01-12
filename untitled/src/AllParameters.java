import java.util.concurrent.atomic.AtomicInteger;

public class AllParameters
{
    public AtomicInteger Temperature, Pressure, Humidity;


    public AllParameters(int Temperature_, int Pressure_, int Humidity_)
    {
        Temperature = new AtomicInteger(Temperature_);
        Pressure = new AtomicInteger(Pressure_);
        Humidity = new AtomicInteger(Humidity_);
    }
}