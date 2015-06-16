package service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import junit.framework.TestCase;
import service.impl.ServiceFactoryImpl;
import util.FieldType;

public class StatsServiceTest extends TestCase {

	StatsService ss;
	
	InferStatsService iss;
	
	protected static void setUpBeforeClass() throws Exception {
	}

	protected static void tearDownAfterClass() throws Exception {
	}

	public StatsServiceTest(){
		try {
			ss = ServiceFactoryImpl.getInstance().getStatsService();
			iss = ServiceFactoryImpl.getInstance().getInferStatsService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void testGetSimpleRegression(){
		try {
			iss.getSimpleRegression(FieldType.AST.ordinal(), "14-15");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public void testGetPlayerRadar() {
		try {
			ss.getPlayerRadar("Kobe Bryant", "13-14", 1);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetPlayerCompareRadar() {
		try {
			ss.getPlayerCompareRadar("Kobe Bryant", "LeBron James", "Career", 2);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetPlayerCareerLineChart() {
		try {
			ss.getPlayerCareerLineChart("Kobe Bryant", 0, 1);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetPlayerBasicCompareBarChart() {
		try {
			List<Integer> list = new ArrayList<Integer>();
			list.add(FieldType.PTS.ordinal());
			list.add(FieldType.AST.ordinal());
//			list.add(FieldType.BLK.ordinal());
//			list.add(FieldType.STL.ordinal());
//			list.add(FieldType.TRB.ordinal());		
//			list.add(FieldType.ORB.ordinal());
//			list.add(FieldType.DRB.ordinal());
//			list.add(FieldType.TOV.ordinal());
//			list.add(FieldType.PF.ordinal());	
			ss.getPlayerBasicCompareBarChart("Kobe Bryant", "James Harden", "Career", list, 1);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetPlayerAdvancedCompareBarChart() {
		try {
			List<Integer> list = new ArrayList<Integer>();
			list.add(FieldType.ORB_PCT.ordinal());
			list.add(FieldType.DRB_PCT.ordinal());
//			list.add(FieldType.TRB_PCT.ordinal());
//			list.add(FieldType.AST_PCT.ordinal());
//			list.add(FieldType.STL_PCT.ordinal());
//			list.add(FieldType.BLK_PCT.ordinal());
//			list.add(FieldType.TOV_PCT.ordinal());
//			list.add(FieldType.USG_PCT.ordinal());
			ss.getPlayerAdvancedCompareBarChart("Kobe Bryant", "Yao Ming", "Career", list, 1);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetPlayerPctCompareBarChart() {
		try {
			List<Integer> list = new ArrayList<Integer>();
			list.add(FieldType.USG_PCT.ordinal());
			list.add(FieldType.FG3_PCT.ordinal());
			list.add(FieldType.FGA_PCT.ordinal());
			list.add(FieldType.FT_PCT.ordinal());
			ss.getPlayerAdvancedCompareBarChart("Kobe Bryant", "Yao Ming", "01-02", list, 1);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetTeamRadar() {
		try {
			ss.getTeamRadar("ATL", "13-14");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetTeamCompareRadar() {
		try {
			ss.getTeamCompareRadar("HOU", "ATL", "12-13");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetTeamCareerLineChar() {
		try {
			ss.getTeamCareerLineChart("ATL", 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetTeamBasicCompareBarChar() {
		try {
			List<Integer> list = new ArrayList<Integer>();
			list.add(FieldType.AST.ordinal());
			list.add(FieldType.STL.ordinal());
			ss.getTeamBasicCompareBarChart("ATL", "HOU", "13-14", list);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetTeamAdvancedCompareBarChart() {
		try {
			List<Integer> list = new ArrayList<Integer>();
			list.add(FieldType.OFF_RTG.ordinal());
			list.add(FieldType.DEF_RTG.ordinal());
			ss.getTeamAdvancedCompareBarChart("ATL", "HOU", "13-14", list);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetTeamPctCompareBarChart() {
		try {
			List<Integer> list = new ArrayList<Integer>();
			list.add(FieldType.FT_PCT.ordinal());
			list.add(FieldType.FGA_PCT.ordinal());
			ss.getTeamPctCompareBarChart("ATL", "HOU", "13-14", list);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetMatchPlayerLineChart() {
		try {
			ss.getMatchPlayerLineChart("Aaron Brooks", "13-14", 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetMatchTeamLineChart() {
		try {
			ss.getMatchTeamLineChart("ATL", "13-14", 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void testGetPlayerContribution() {
		try {
			ss.getPlayerContribution("ATL", "13-14");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

    public static void main(String[] args) throws RemoteException {
        StatsService ss = ServiceFactoryImpl.getInstance().getStatsService();
//        ImageIcon img = ss.getPlayerCompareRadar("Kobe Bryant", "Yao Ming", "Career", 1);
//        ImageIcon img = ss.getPlayerRadar("Kobe Bryant", "Career", 1);
//        ImageIcon img = ss.getTeamRadar("BOS", "13-14");
//        ImageIcon img = ss.getTeamCompareRadarByGameId("201506110CLE-GSW");
        List<Integer> list = new ArrayList<>();
        list.add(FieldType.AST_PCT.ordinal());
//        list.add(FieldType.TOV_PCT.ordinal());
//        ImageIcon img = ss.getPlayerCareerLineChart("Yao Ming", FieldType.TRB, 1);
//        ImageIcon img = ss.getTeamCareerLineChar("BOS", FieldType.TRB);
//        ImageIcon img = ss.getTeamCareerLineChar("BOS", FieldType.DRB_PCT);
//        ImageIcon img = ss.getTeamBasicCompareBarChart("CLE", "GSW", "14-15", list);
//        ImageIcon img = ss.getPlayerBasicCompareBarChart("Kobe Bryant", "Yao Ming", "Career", list, 1);
//        ImageIcon img = ss.getMatchTeamLineChart("HOU", "14-15", FieldType.typeToInt(FieldType.PTS));
//        ImageIcon img = ss.getPlayerContribution("HOU", "13-14");
        ImageIcon img = ss.getPlayerAdvancedCompareBarChart("Kobe Bryant", "Yao Ming", "Career", list, 1);
        img = ss.getMatchTeamLineChart("CLE", "14-15", FieldType.PTS.ordinal());
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1366, 700);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        JLabel j = new JLabel(img);
        panel.add(j);
        frame.setContentPane(panel);
        frame.revalidate();
    }
	
}
