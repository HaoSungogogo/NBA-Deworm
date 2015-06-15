package ui.player;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.config.PanelConfig;
import ui.config.SystemConfig;
import ui.home.HomeUI;
import ui.player.hot.PlayerHotPane;
import ui.util.MyLabel;

public class PlayerNav extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelConfig pcfg;
	private Image bg;
	
	private HomeUI frame;
	private MyLabel index;
	private MyLabel playerstat;
	private MyLabel hotplayer;
	private MyLabel playerpast;
	int show =0;
	
	public PlayerNav(HomeUI frame){
	this.pcfg = SystemConfig.getHOME_CONFIG().getConfigMap()
			.get(this.getClass().getName());
	this.frame = frame;
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
		index.setIcon(new ImageIcon("img/player/nav/index_click.png"));
		index.addMouseListener(new MouseAdapter(){
			String[] temp = pcfg.getLabels().element("index").attributeValue("path").split("\\.");
			String path = temp[0];
			String fix = temp[1];
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				index.setIcon(new ImageIcon(path+"_click."+fix));
				show = 0;
				playerstat.setIcon(new ImageIcon(pcfg.getLabels().element("playerstat").attributeValue("path")));
				hotplayer.setIcon(new ImageIcon(pcfg.getLabels().element("hotplayer").attributeValue("path")));
				playerpast.setIcon(new ImageIcon(pcfg.getLabels().element("playerpast").attributeValue("path")));
			
				//更改playerpanel内容
				hintAll();
				frame.motherPanel.playerPanel.indexpanel.setVisible(true);
				
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
				hotplayer.setIcon(new ImageIcon(pcfg.getLabels().element("hotplayer").attributeValue("path")));
				playerpast.setIcon(new ImageIcon(pcfg.getLabels().element("playerpast").attributeValue("path")));
				
				//更改playerpanel内容
				hintAll();
				frame.motherPanel.playerPanel.playerstat.setVisible(true);
				frame.motherPanel.playerPanel.setting.setVisible(true);
				frame.motherPanel.playerPanel.menu.setVisible(true);
				
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
		hotplayer = new MyLabel(pcfg.getLabels().element("hotplayer"));
		hotplayer.addMouseListener(new MouseAdapter(){
			String[] temp = pcfg.getLabels().element("hotplayer").attributeValue("path").split("\\.");
			String path = temp[0];
			String fix = temp[1];
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hotplayer.setIcon(new ImageIcon(path+"_click."+fix));
				show = 2;
				index.setIcon(new ImageIcon(pcfg.getLabels().element("index").attributeValue("path")));
				playerstat.setIcon(new ImageIcon(pcfg.getLabels().element("playerstat").attributeValue("path")));
				playerpast.setIcon(new ImageIcon(pcfg.getLabels().element("playerpast").attributeValue("path")));
			
				//更改playerpanel内容
				hintAll();
				frame.motherPanel.playerPanel.playerHotPane.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				hotplayer.setIcon(new ImageIcon(path+"_click."+fix));	
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if(show!=2)
					hotplayer.setIcon(new ImageIcon(path+"."+fix));
		
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				hotplayer.setIcon(new ImageIcon(path+"_click."+fix));
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				hotplayer.setIcon(new ImageIcon(path+"_click."+fix));
				
			}
			
		});
		playerpast = new MyLabel(pcfg.getLabels().element("playerpast"));
		playerpast.addMouseListener(new MouseAdapter(){
			String[] temp = pcfg.getLabels().element("playerpast").attributeValue("path").split("\\.");
			String path = temp[0];
			String fix = temp[1];
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				playerpast.setIcon(new ImageIcon(path+"_click."+fix));
				show = 3;
				index.setIcon(new ImageIcon(pcfg.getLabels().element("index").attributeValue("path")));
				hotplayer.setIcon(new ImageIcon(pcfg.getLabels().element("hotplayer").attributeValue("path")));
				playerstat.setIcon(new ImageIcon(pcfg.getLabels().element("playerstat").attributeValue("path")));
			
				//更改playerpanel内容
				hintAll();
				frame.motherPanel.playerPanel.compareChoosePanel.setVisible(true);
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				playerpast.setIcon(new ImageIcon(path+"_click."+fix));	
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if(show!=3)
					playerpast.setIcon(new ImageIcon(path+"."+fix));
		
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				playerpast.setIcon(new ImageIcon(path+"_click."+fix));
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				playerpast.setIcon(new ImageIcon(path+"_click."+fix));
				
			}
			
		});
		
		add(index);
		add(playerstat);
		add(hotplayer);
		add(playerpast);
	}
	
	
	public void hintAll(){
		frame.motherPanel.playerPanel.comparePanel.setVisible(false);
		frame.motherPanel.playerPanel.compareChoosePanel.setVisible(false);
		frame.motherPanel.playerPanel.fourTablePane.setVisible(false);
		frame.motherPanel.playerPanel.playerInfoPane.setVisible(false);
		frame.motherPanel.playerPanel.indexpanel.setVisible(false);
		frame.motherPanel.playerPanel.playerstat.setVisible(false);
		frame.motherPanel.playerPanel.playerHotPane.setVisible(false);
		frame.motherPanel.playerPanel.setting.setVisible(false);
		frame.motherPanel.playerPanel.menu.setVisible(false);
	}
	
	public void setColor(int num){
		if(num == 3){
			returnColor();
			String[] temp = pcfg.getLabels().element("playerpast").attributeValue("path").split("\\.");
			String path = temp[0];
			String fix = temp[1];
			playerpast.setIcon(new ImageIcon(path+"_click."+fix));
			
		}
		if(num == 2){
			returnColor();
			String[] temp = pcfg.getLabels().element("hotplayer").attributeValue("path").split("\\.");
			String path = temp[0];
			String fix = temp[1];
			hotplayer.setIcon(new ImageIcon(path+"_click."+fix));
			
		}
		if(num == 1){
			returnColor();
			String[] temp = pcfg.getLabels().element("playerstat").attributeValue("path").split("\\.");
			String path = temp[0];
			String fix = temp[1];
			playerstat.setIcon(new ImageIcon(path+"_click."+fix));
			
		}
		if(num ==0){
			returnColor();
			String[] temp = pcfg.getLabels().element("index").attributeValue("path").split("\\.");
			String path = temp[0];
			String fix = temp[1];
			index.setIcon(new ImageIcon(path+"_click."+fix));
			
		}
	}
	
	public void returnColor(){
		String[] temp = pcfg.getLabels().element("playerpast").attributeValue("path").split("\\.");
		String path = temp[0];
		String fix = temp[1];
		playerpast.setIcon(new ImageIcon(path+"."+fix));
		
		 temp = pcfg.getLabels().element("hotplayer").attributeValue("path").split("\\.");
		 path = temp[0];
		 fix = temp[1];
		 hotplayer.setIcon(new ImageIcon(path+"."+fix));
		 
		 temp = pcfg.getLabels().element("playerstat").attributeValue("path").split("\\.");
		 path = temp[0];
		 fix = temp[1];
		 playerstat.setIcon(new ImageIcon(path+"."+fix));
		 
		 temp = pcfg.getLabels().element("index").attributeValue("path").split("\\.");
		 path = temp[0];
		 fix = temp[1];
		 index.setIcon(new ImageIcon(path+"."+fix));

	}
}
