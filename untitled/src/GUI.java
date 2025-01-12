import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GUI implements Runnable
{
    private JFrame frame;
    private List<JLabel> labelsList;
    private AllParameters allParameters;


    public GUI(AllParameters allParameters_)
    {
        allParameters = allParameters_;
        frame = new JFrame();

        createLabels();
        updateLabelsText();
        setLabelsPosition();

        frame.setSize(600, 300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showGUIElements();
    }

    private void createLabels()
    {
        var labels = Arrays.asList(new JLabel(), new JLabel(), new JLabel(), new JLabel());
        labelsList = new ArrayList<JLabel>(labels);
    }

    @Override
    public void run()
    {
        while (true) {
            try {
                updateLabelsText();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateLabelsText()
    {
        StringBuilder temperatureString = new StringBuilder("Temperatura (w °C): ");
        temperatureString.append(allParameters.Temperature);
        StringBuilder pressureString = new StringBuilder("Ciśnięcie (w mm): ");
        pressureString.append(allParameters.Pressure);
        StringBuilder HumidityString = new StringBuilder("Wilgotność (w %): ");
        HumidityString.append(allParameters.Humidity);

        List<StringBuilder> parametersList = new ArrayList<StringBuilder>();
        parametersList.add(temperatureString);
        parametersList.add(pressureString);
        parametersList.add(HumidityString);

        System.out.println(allParameters.Humidity);
        int i = 0;
        for (StringBuilder string : parametersList)
        {
            labelsList.get(i).setText(string.toString());

            ++i;
        }
    }

    private void setLabelsPosition()
    {
        int x = 50, y = 50, width = 150, height = 150;

        for (JLabel label : labelsList)
        {
            label.setBounds(x, y, width, height);
            x += 200;
        }
    }

    private void showGUIElements()
    {
        frame.setVisible(true);


        for (JLabel label : labelsList) frame.add(label);
    }
}