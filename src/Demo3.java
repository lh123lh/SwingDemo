
/*
*绘制柱状图 
*/

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Demo3 extends JFrame {

	// constructor
	public Demo3() {

		JPanel jp = new getLine2Panel().getLine();

		this.add(jp);

		this.setTitle("折线图");

		this.setExtendedState(Frame.MAXIMIZED_BOTH);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.pack();

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Demo3();

	}
}

class getLine2Panel {
	private Random ran;

	public JPanel getLine() {
		ran = new Random();

		// 构造DataSet
		DefaultCategoryDataset DataSet = new DefaultCategoryDataset();

		for (int i = 0; i < 1024; i++) {
			int value = ran.nextInt(10) + 10;// 随机随机数

			DataSet.addValue(value, "number", "" + i);
		}

		// 创建折线图
		JFreeChart chart = ChartFactory.createLineChart("Catogram", "Index", "Enarge", DataSet,
				PlotOrientation.VERTICAL, false, false, false);

		// 用来放置图表
		ChartPanel panel = new ChartPanel(chart);

		// 设置panel大小
		panel.setPreferredSize(new Dimension(1500, 1000));

		JPanel jp = new JPanel();

		jp.add(panel, BorderLayout.CENTER);

		return jp;
	}
}