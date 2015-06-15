package ui.match;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import ui.config.PanelConfig;
import ui.config.SystemConfig;
import ui.home.HomeUI;
import ui.live.LiveChoosePane;
import ui.match.info.MatchInfoPanel;
import ui.match.stat.MatchDetail;
import ui.match.stat.MatchStat;

public class MatchPanel extends JPanel{

	private PanelConfig pcfg;
	private HomeUI frame;
	private Image bg;
	
	public  LiveChoosePane liveChoosePane;
	public MatchStat matchStat;
	public MatchInfoPanel matchInfoPanel;
	public MatchDetail matchDetail;
	public MatchPanel(HomeUI frame){
		this.pcfg = SystemConfig.getHOME_CONFIG().getConfigMap()
				.get(this.getClass().getName());
		this.frame = frame;
		this.bg = pcfg.getBg();
		
		this.setLayout(null);
		this.setOpaque(false);
		this.setSize(pcfg.getW(), pcfg.getH());
		this.setLocation(pcfg.getX(),pcfg.getY());
		
		initComponent();
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(bg, 0, 0, pcfg.getW(), pcfg.getH(), null);
	}
	
	private void initComponent(){
		initPanels();
	}
	
	private void initPanels(){
		liveChoosePane = new LiveChoosePane(frame);
		liveChoosePane.setVisible(false);
		add(liveChoosePane);
		
		matchStat = new MatchStat(frame);
		//matchStat.setVisible(false);
		add(matchStat);
		
		matchInfoPanel =new MatchInfoPanel(frame);
		matchInfoPanel.setVisible(false);
		add(matchInfoPanel);
		
		matchDetail =new MatchDetail(frame);
		matchDetail.setVisible(false);
		add(matchDetail);
		
	}

    public void recoverFirst() {
        switchPanel(0);
        frame.motherPanel.matchnav.recoverFirst();
    }

    public void switchPanel(int show) {
        if (show == 0) {
        	matchInfoPanel.setVisible(false);
        	matchStat.setVisible(true);
            liveChoosePane.setVisible(false);
            liveChoosePane.removeLivePanel();
        } else if (show == 1) {
        	matchInfoPanel.setVisible(false);
            matchDetail.setVisible(false);
            matchStat.setVisible(false);
        	matchStat.setVisible(false);
            liveChoosePane.setVisible(true);
            liveChoosePane.removeLivePanel();
        }
    }
}
