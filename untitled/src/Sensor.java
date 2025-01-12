import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Sensor implements Runnable
{
    private AtomicInteger data;


    public Sensor(AtomicInteger data_) {
        data = data_;
    }

    private void setData()
    {
        int min = -5, max = 5;
        int k = min + new Random().nextInt(max - min + 1);

        data.addAndGet(k);
    }

    @Override
    public void run()
    {
        while (true) {
            try {
                setData();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}