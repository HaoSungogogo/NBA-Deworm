package util;

public enum FieldType {
	
	// 得分
    PTS,     
    //篮板
	TRB, 
	//进攻篮板
	ORB,
	//防守篮板
	DRB,
	//助攻
	AST,
	//盖帽
	BLK, 
	//抢断
	STL, 
	//失误
	TOV,
	//犯规
	PF,
	//三分命中率
	FG3_PCT,
	//投篮命中率
	FGA_PCT,
	//罚球命中率
	FT_PCT,
	//效率（球员高阶）
	PER,
	//真实命中率
	TS_PCT,
	//抢断率
	STL_PCT,
	//盖帽率
	BLK_PCT,
	//助攻率
	AST_PCT,
	//失误率
	TOV_PCT,
	//使用率（球员高阶）
	USG_PCT,    
	//篮板率
	TRB_PCT,
    //进攻篮板效率(球员球队高阶)
    ORB_PCT,
    //防守篮板效率(球员球队高阶)
    DRB_PCT,
    //进攻效率(球队高阶)
    OFF_RTG,
    //防守效率(球队高阶)
    DEF_RTG,
    //进攻-有效命中率
    OFF_EFG_PCT,
    //进攻-失误率
    OFF_TOV_PCT,
    //防守-有效命中率
    OPP_EFG_PCT,
    //防守-失误率
    OPP_TOV_PCT,
    //SOS
    SOS,
    //SRS
    SRS,
    //MOV
    MOV;
    
    @Override
    public String toString(){
    	return super.toString().toLowerCase();
    }
    
	/**
	 * 判断数据是否为球员高阶数据类型
	 */
	public static boolean isFieldAdvanced(FieldType field) {
		switch (field) {
		case PTS:
		case AST:
		case STL:
		case BLK:
		case TRB:
		case DRB:
		case ORB:
		case TOV:
		case PF:
		case FG3_PCT:
		case FGA_PCT:
		case FT_PCT:
			return false;
		default:
			return true;
		}
	}
}
