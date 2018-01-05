package kata6.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import kata6.model.Histogram;

public class HistogramDisplay<T> extends ApplicationFrame {
    
    private final Histogram<T> histo;
    private final String nameEjeX;
    
    public HistogramDisplay(Histogram<T> histo, String nameEjeX){
        super("HISTOGRAMA");
        this.histo = histo;
        this.nameEjeX = nameEjeX;
        setContentPane(createPanel());
        pack();
    }
    
    private JPanel createPanel(){
        ChartPanel panel = new ChartPanel(createChart(createDataset()));
        panel.setPreferredSize(new Dimension(500,400));
        return panel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart
                           ("Histograma JFreeChart",nameEjeX,"Nº",
                             dataSet,PlotOrientation.VERTICAL,false,
                             rootPaneCheckingEnabled,rootPaneCheckingEnabled);
        return chart;     
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (T key: histo.keySet()) {	
            dataSet.addValue(histo.get(key),"",(Comparable)key);	
}
        return dataSet;
    }
    
    public void execute() {
        setVisible(true);
    }
}
