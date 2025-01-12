import java.util.concurrent.atomic.AtomicInteger;

public class Main
{
    public static void main(String[] args)
    {
        AllParameters allParameters = new AllParameters(20, 760, 50);
        GUI gui = new GUI(allParameters);

        Sensor temperatureSensor = new Sensor(allParameters.Temperature);
        Sensor pressureSensor = new Sensor(allParameters.Pressure);
        Sensor humiditySensor = new Sensor(allParameters.Humidity);

        new Thread(temperatureSensor).start();
        new Thread(pressureSensor).start();
        new Thread(humiditySensor).start();
        new Thread(gui).start();
    }
}