package vo;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class SimpleRegressionVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 回归系数b
	 */
	public double b;
	
	/**
	 * 回归系数a
	 */
	public double a;
	
	/**
	 * 偏差平方和q
	 */
	public double q;
	
	/**
	 * 平均标准偏差s
	 */
	public double s;
	
	/**
	 * 回归平方和p
	 */
	public double p;
	
	/**
	 * 最大偏差umax
	 */
	public double umax;
	
	/**
	 * 最小偏差umin
	 */
	public double umin;
	
	/**
	 * 偏差平均值u
	 */
	public double u;
	
	/**
	 * 相关系数
	 */
	public double r;
	
	/**
	 * p值
	 */
	public double p_value;
	
	/**
	 * Standard error of the estimate
	 */
	public double str_err;
	
	/**
	 * 散点图
	 */
	public ImageIcon img;
	
	public SimpleRegressionVO(){}
}
