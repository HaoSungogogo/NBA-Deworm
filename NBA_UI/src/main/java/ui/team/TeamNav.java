package ui.team;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.config.PanelConfig;
import ui.config.SystemConfig;
import ui.util.MyLabel;

public class TeamNav extends JPanel{
	private PanelConfig pcfg;
	private Image bg;
	
	private MyLabel index;
	private MyLabel playerstat;
	private MyLabel hotteam;

	int show =0;
	
	public TeamNav(){
	this.pcfg = SystemConfig.getHOME_CONFIG().getConfigMap()
			.get(this.getClass().getName());
	this.bg = pcfg.getBg();
	
	this.setLayout(null);
	this.setSize(pcfg.getW(),pcfg.getH());
	this.setLocation(pcfg.getX(), pcfg.getY());
	
	initComponent();
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(bg, 0, 0, pcfg.getW(), pcfg.getH(), null);
	}
	
	public void initComponent(){
		initLabels();
	}
	
	private void initLabels(){
		index = new MyLabel(pcfg.getLabels().element("index"));
		index.addMouseListener(new MouseAdapter(){
			String[] temp = pcfg.getLabels().element("index").attributeValue("path").split("\\.");
			String path = temp[0];
			String fix = temp[1];
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				index.setIcon(new ImageIcon(path+"_click."+fix));
				show = 0;
				playerstat.setIcon(new ImageIcon(pcfg.getLabels().element("playerstat").attributeValue("path")));
				hotteam.setIcon(new ImageIcon(pcfg.getLabels().element("hotteam").attributeValue("path")));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				index.setIcon(new ImageIcon(path+"_click."+fix));	
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if(show!=0)
				index.setIcon(new ImageIcon(path+"."+fix));
		
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				index.setIcon(new ImageIcon(path+"_click."+fix));
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				index.setIcon(new ImageIcon(path+"_click."+fix));
				
			}
			
		});
		playerstat = new MyLabel(pcfg.getLabels().element("playerstat"));
		playerstat.addMouseListener(new MouseAdapter(){
			String[] temp = pcfg.getLabels().element("playerstat").attributeValue("path").split("\\.");
			String path = temp[0];
			String fix = temp[1];
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				playerstat.setIcon(new ImageIcon(path+"_click."+fix));
				show =1;
				index.setIcon(new ImageIcon(pcfg.getLabels().element("index").attributeValue("path")));
				hotteam.setIcon(new ImageIcon(pcfg.getLabels().element("hotplayer").attributeValue("path")));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				playerstat.setIcon(new ImageIcon(path+"_click."+fix));	
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if(show!=1)
					playerstat.setIcon(new ImageIcon(path+"."+fix));
		
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				playerstat.setIcon(new ImageIcon(path+"_click."+fix));
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				playerstat.setIcon(new ImageIcon(path+"_click."+fix));
				
			}
			
		});
		hotteam = new MyLabel(pcfg.getLabels().element("hotteam"));
		hotteam.addMouseListener(new MouseAdapter(){
			String[] temp = pcfg.getLabels().element("hotteam").attributeValue("path").split("\\.");
			String path = temp[0];
			String fix = temp[1];
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hotteam.setIcon(new ImageIcon(path+"_click."+fix));
				show = 2;
				index.setIcon(new ImageIcon(pcfg.getLabels().element("index").attributeValue("path")));
				playerstat.setIcon(new ImageIcon(pcfg.getLabels().element("playerstat").attributeValue("path")));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				hotteam.setIcon(new ImageIcon(path+"_click."+fix));	
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if(show!=2)
					hotteam.setIcon(new ImageIcon(path+"."+fix));
		
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				hotteam.setIcon(new ImageIcon(path+"_click."+fix));
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				hotteam.setIcon(new ImageIcon(path+"_click."+fix));
				
			}
			
		});
		
		add(index);
		add(playerstat);
		add(hotteam);
	}
}